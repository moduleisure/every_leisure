package com.webproject.molei.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Shop() {};

    protected Shop(Long id, String name, String phoneNumber, String opening_time, String closing_time) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.opening_time = opening_time;
        this.closing_time = closing_time;
    }

    public static Shop of(Long id, String name, String phoneNumber, String opening_time, String closing_time)
    {
        return new Shop( id, name,  phoneNumber, opening_time, closing_time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop shop)) return false;
        return id != null && id.equals(shop.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
