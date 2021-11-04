package com.back.shop.user;

import com.back.shop.order.OrderResponseBuilder;
import com.back.shop.order.entity.Order;
import com.back.shop.order.entity.QOrder;
import com.back.shop.user.entity.QUser;
import com.back.shop.user.entity.User;
import com.querydsl.core.Tuple;

import java.util.List;
import java.util.stream.Collectors;

public class UserOrderResponseBuilder {

    public static List<UserOrderResponse> of(List<Tuple> tuples) {
        return tuples.stream().map(UserOrderResponseBuilder::one).collect(Collectors.toList());
    }

    public static UserOrderResponse one(Tuple tuple) {
        User user = tuple.get(QUser.user);
        Order order = tuple.get(QOrder.order);

        assert user != null;
        order = order == null ? new Order() : order;

        return UserOrderResponse
                .builder()
                .userResponse(UserResponseBuilder.one(user))
                .orderResponse(OrderResponseBuilder.one(order))
                .build();
    }
}
