package com.back.shop.domain;

import com.back.shop.order.Order;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void order() {
        new Order("123kjf", "제품명은");
    }

}