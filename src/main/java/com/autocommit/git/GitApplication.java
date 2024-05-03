package com.autocommit.git;

import com.autocommit.git.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class GitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitApplication.class, args);
    }

}
