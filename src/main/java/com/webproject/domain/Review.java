package com.webproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Review {

    @Id
    private Long id;

    private String userID;
    private String leisureId;
    private LocalDateTime createdAt;
    private String shopContent;
    private Double shopRating;
    //private

}
