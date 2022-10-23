package com.webproject.molei.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100, nullable= false) private String name;
    @Column(length=100, nullable= false) private String phoneNumber;
    @Column(length=100, nullable= false) private String opening_time;
    @Column(length=100, nullable= false) private String closing_time;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Users admin;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "shop", cascade = ALL)
    private List<ShopCategory> shopCategories = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = ALL)
    private List<Review> reviews = new ArrayList<>();

}
