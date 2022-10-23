package com.webproject.domain;

import javax.persistence.Id;
import java.time.LocalDateTime;

public class User {

    @Id
    private Long id;

    private String userEmail;
    private String userPassword;
    private String roleType;
    private String nickName;
    private LocalDateTime birthDay;
    private String phoneNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




}
