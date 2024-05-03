package com.autocommit.git.user;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class MyConfig {

    public static String username;
    public static String accessToken;

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/application.yml"));
            username = properties.getProperty("github.username");
            accessToken = properties.getProperty("github.access-token");
        } catch (IOException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }
    }

    // 특정 키에 대한 값을 반환하는 메서드
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // 예제 사용
    public static void main(String[] args) {
        // 특정 키에 대한 값을 가져와서 출력
        String title = MyConfig.getProperty("github.username");
        String description = MyConfig.getProperty("github.access-token");
        System.out.println("username: " + title);
        System.out.println("access-token: " + description);
        System.out.println("username = " + username);
    }

}
