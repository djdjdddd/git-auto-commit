package com.autocommit.git;

import com.autocommit.git.user.User;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
public class AutoPush {

    // TODO. 하루에 한번 실행하게 하려면 어떻게 해야 되지??

    private static String ORIGIN = "origin";
    private static String MAIN = "main";

    public static void main(String[] args) {
        // TODO. 파일 타입(생성/수정/삭제)을 인식해서 커밋 컨벤션 자동으로 생성되게 할 수 없을까??
        // 생성 -> Feat: Xxx 생성
        // 삭제 -> Remove: Xxx 삭제
        
        
        // TODO. 코드 리팩토링
        // 로컬 레포와 리모트 레포를 연결하는 코드
        String folderPath = "C:\\Users\\SSS\\IdeaProjects\\git";
        try {
            Git git = Git.open(new File(folderPath));
            RemoteAddCommand remoteAddCommand = git.remoteAdd();
            remoteAddCommand.setName(ORIGIN);

            System.out.println("open pass");    // TODO. 중간 진행 정도를 체크하여 만약 에러가 났을 경우 어디서 났는지 쉽게 체크되도록
                                                // TODO. 단계별 시각화 안되나??

            // 여기에는 리모트 레포의 경로를 넣어주자
            remoteAddCommand.setUri(new URIish("https://github.com/djdjdddd/git-auto-commit.git"));

            System.out.println("setUri pass");

            // git add . 의 역할
            git.add().addFilepattern(".").call();
            remoteAddCommand.call();

            System.out.println("add pass");

            // git commit -M "커밋 메시지" 역할
            git.commit().setMessage("auto commit test").call();

            System.out.println("commit pass");

            // git push origin main 역할
            git.push()
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(User.username, User.accessToken))
                    .setRemote(ORIGIN).add(MAIN)
                    .call();

            System.out.println("push pass");
        } catch (IOException | GitAPIException | URISyntaxException e) {
            // TODO. Exception 처리 조금 더 세분화
            log.error("error", e);
            throw new RuntimeException(e);
        }

    }

}
