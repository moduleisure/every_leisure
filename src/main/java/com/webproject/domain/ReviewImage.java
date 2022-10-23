package com.webproject.domain;

import javax.persistence.Id;

public class ReviewImage {

    @Id
    private Long id;

    private String reviewId;
    private String urlImage;
}
