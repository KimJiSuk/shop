package com.back.shop.domain;

import java.time.ZonedDateTime;

public class Order {
    private final int ORDER_NUMBER_MAX_LENGTH = 12;
    private final int PRODUCT_NAME_MAX_LENGTH = 100;

    private final String orderNumber;
    private final String productName;
    private final ZonedDateTime orderAt;

    public Order(String orderNumber, String productName) {
        this.orderNumber = validateOrderNumber(orderNumber);
        this.productName = validateProductName(productName);
        this.orderAt = ZonedDateTime.now();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public ZonedDateTime getOrderAt() {
        return orderAt;
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
