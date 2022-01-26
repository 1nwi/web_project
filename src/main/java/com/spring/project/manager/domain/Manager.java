package com.spring.project.manager.domain;

import lombok.*;

import java.sql.Timestamp;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Manager {

    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private Timestamp regDate;
    private Auth auth;
}
