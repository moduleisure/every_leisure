package com.webproject.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

//@Entity
public class ShopCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "leisure_category_id")
    private Category category;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "leisure_shop_id")
    private Shop shop;
}
