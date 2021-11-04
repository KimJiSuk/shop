package com.back.shop.order;

import com.back.shop.order.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderResponseBuilder {

    public static List<OrderResponse> of(List<Order> orders) {
        return orders.stream().map(OrderResponseBuilder::one).collect(Collectors.toList());
    }

    public static OrderResponse one(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .orderNumber(order.getOrderNumber())
                .productName(order.getProductName())
                .orderAt(order.getOrderAt())
                .build();
    }
}
