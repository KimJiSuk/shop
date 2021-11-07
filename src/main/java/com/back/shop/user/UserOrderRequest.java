package com.back.shop.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserOrderRequest {

    @ApiModelProperty(value = "Pageable offset", example = "1", required = true)
    private Long offset;

    @ApiModelProperty(value = "Pageable size", example = "5", required = true)
    private Long size;

    @ApiModelProperty(value = "검색할 유저 이름, DB like 연산", required = true)
    private String name;

    @ApiModelProperty(value = "검색할 유저 이메일, DB like 연산", example = "yes0229@gmail.com", required = true)
    private String email;

}
