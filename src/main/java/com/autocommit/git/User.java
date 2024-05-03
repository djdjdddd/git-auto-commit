package com.autocommit.git;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@ToString
public class User {

    @Value("${github.username}")
    private String userName;

    @Value("${github.access-token}")
    private String password;

}
