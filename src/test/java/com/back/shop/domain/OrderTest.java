package com.back.shop.domain;

import com.back.shop.order.OrderInfo;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void order() {
        new OrderInfo("123kjf", "제품명은");
    }

}