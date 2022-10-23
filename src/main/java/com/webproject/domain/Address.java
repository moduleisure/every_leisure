package com.webproject.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address
{
    @Id
    private Long id;

    private String city;
    private String district;
    private String town;
    private String detail;

}
