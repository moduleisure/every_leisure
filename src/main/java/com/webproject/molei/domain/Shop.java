package com.webproject.molei.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;

@Getter @Setter
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100, nullable= false) private String name;
    @Column(length=100, nullable= false) private String phoneNumber;
    @Column(length=100, nullable= false) private String openingTime;
    @Column(length=100, nullable= false) private String closingTime;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Users admin;

    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(name = "ShopCategory",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = ALL)
    private List<Review> reviews = new ArrayList<>();

    public Shop() {};

    protected Shop(String name, String phoneNumber, String openingTime, String closingTime) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public static Shop of(String name, String phoneNumber, String opening_time, String closing_time)
    {
        return new Shop(name,  phoneNumber, opening_time, closing_time);
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
