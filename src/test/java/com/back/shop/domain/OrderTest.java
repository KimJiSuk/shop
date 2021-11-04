package com.back.shop.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void order() {
        new Order("123kjf", "제품명은");
    }

}