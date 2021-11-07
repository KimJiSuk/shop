package com.back.shop.order.domain;

import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class OrderInfo {
    private final int ORDER_NUMBER_MAX_LENGTH = 12;
    private final int PRODUCT_NAME_MAX_LENGTH = 100;

    private final String orderNumber;
    private final String productName;
    private final ZonedDateTime orderAt;

    public OrderInfo(String orderNumber, String productName) {
        this.orderNumber = validateOrderNumber(orderNumber);
        this.productName = validateProductName(productName);
        this.orderAt = ZonedDateTime.now();
    }

    private String validateOrderNumber(String orderNumber) {
        if (orderNumber.length() > ORDER_NUMBER_MAX_LENGTH) {
            throw new IllegalArgumentException("Order Number max length 12. input : " + orderNumber);
        }

        return orderNumber;
    }

    private String validateProductName(String productName) {
        if (productName.length() > PRODUCT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Product Name max length 100. input : " + productName);
        }

        return productName;
    }
}
