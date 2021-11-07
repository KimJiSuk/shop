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
public class UserLoginRequest {

    @ApiModelProperty(value = "이메일", example = "yes0229@gmail.com", required = true)
    private String email;

    @ApiModelProperty(value = "비밀번호", example = "wltjrwltjr", required = true)
    private String password;
}
