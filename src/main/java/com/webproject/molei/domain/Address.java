package com.webproject.molei.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Address
{
    private String city;
    private String district;
    private String town;
    private String detail;

    public Address(String city, String district, String town, String detail) {
        this.city = city;
        this.district = district;
        this.town = town;
        this.detail = detail;
    }
}
