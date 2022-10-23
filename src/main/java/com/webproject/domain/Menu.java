package com.webproject.domain;

import javax.persistence.Id;

public class Menu {

    @Id
    private Long id;

    private String shopId;
    private String menuName;
    private String menuPrice;
    private String menuDescription;
    private String startTime;
    private String endTime;

}
