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
public class UserJoinRequest {

    @ApiModelProperty(value = "이름", required = true)
    private String name;

    @ApiModelProperty(value = "별명", required = true)
    private String nickname;

    @ApiModelProperty(value = "비밀번호", required = true)
    private String password;

    @ApiModelProperty(value = "전화번호", required = true)
    private String phoneNumber;

    @ApiModelProperty(value = "이메일", required = true)
    private String email;

    @ApiModelProperty(value = "성별")
    private String sex;

}
