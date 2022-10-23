package com.webproject.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@ToString
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100, nullable= false) private String name;
    @Column(length=100, nullable= false) private String phoneNumber;
    @Column(length=100, nullable= false) private String opening_time;
    @Column(length=100, nullable= false) private String closing_time;

    private Long admin_id;
    private Long address_id;


    protected Shop() {}


}
