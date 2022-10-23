package com.webproject.molei.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity

public class Menu {

    @Id
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    private String menuName;
    private String menuPrice;
    private String menuDescription;
    private String startTime;
    private String endTime;

}
