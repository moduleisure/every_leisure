package com.webproject.domain;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();
}
