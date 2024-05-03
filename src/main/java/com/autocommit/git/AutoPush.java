package com.autocommit.git;

import com.autocommit.git.user.MyConfig;
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

    private static String ORIGIN = "origin";
    private static String MAIN = "main";

    public static void main(String[] args) {

        // 깃 사용자 정보를 담은 객체
//        log.info("user = {}", user);

        // 로컬 레포와 리모트 레포를 연결하는 코드
        String folderPath = "C:\\Users\\SSS\\IdeaProjects\\git";
        try {
            Git git = Git.open(new File(folderPath));
            RemoteAddCommand remoteAddCommand = git.remoteAdd();
            remoteAddCommand.setName(ORIGIN);

            System.out.println("open pass");

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
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(MyConfig.username, MyConfig.accessToken))
                    .setRemote(ORIGIN).add(MAIN)
                    .call();

            System.out.println("push pass");
        } catch (IOException | GitAPIException | URISyntaxException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }

    }

}
