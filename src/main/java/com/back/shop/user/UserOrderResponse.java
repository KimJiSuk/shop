package com.back.shop.user;

import com.back.shop.order.OrderResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserOrderResponse {
    private UserResponse userResponse;
    private OrderResponse orderResponse;
}
