package com.back.shop.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.ZonedDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {

    @ApiModelProperty(value = "주문 아이디", required = true)
    private Long id;

    @ApiModelProperty(value = "유저 아이디", required = true)
    private Long userId;

    @ApiModelProperty(value = "주문 번호", required = true)
    private String orderNumber;

    @ApiModelProperty(value = "제품명", required = true)
    private String productName;

    @ApiModelProperty(value = "주문 시간", required = true)
    private ZonedDateTime orderAt;

}
