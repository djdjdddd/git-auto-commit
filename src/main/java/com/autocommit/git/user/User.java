package com.autocommit.git.user;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class User {

    public static String githubId;

    public static String githubAccessToken;

    private static String GITHUB_ID = "github.id";

    private static String GITHUB_ACCESS_TOKEN = "github.access-token";

    private static String PROPERTIES_FILE_PATH = "src/main/resources/application.properties";

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
            githubId = properties.getProperty(GITHUB_ID);
            githubAccessToken = properties.getProperty(GITHUB_ACCESS_TOKEN);
        } catch (IOException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }
    }

}
