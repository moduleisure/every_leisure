package com.webproject.molei.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional(readOnly = true)
@Rollback(value = false)
class ShopTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    public void 상점_CRUD() {
        Shop shop = Shop.of("성표네 수상스키", "01012341234", "0900", "1000");
        Category category = new Category("수상스키");
        Category category1 = new Category("테스트");

        shop.getCategories().add(category);
        category.getShops().add(shop);

        em.persist(shop);
        em.persist(category);
        em.persist(Shop.of("1", "1", "1", "1"));
        em.persist(category1);
        em.flush();

        Shop findShop = em.find(Shop.class, shop.getId());

        assertThat(findShop.getName()).isEqualTo("성표네 수상스키");
        assertThat(findShop.getPhoneNumber()).isEqualTo("01012341234");
        assertThat(findShop.getOpeningTime()).isEqualTo("0900");
        assertThat(findShop.getClosingTime()).isEqualTo("1000");
        assertThat(findShop.getCategories().get(0).getName()).isEqualTo("수상스키");

    }
}