package com.autocommit.git.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Builder
@Getter
public class User {

    @Value("${github.username}")
    private String userName;

    @Value("${github.access-token}")
    private String password;

}
