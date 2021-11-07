package com.back.shop.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    @ApiModelProperty(value = "id", required = true)
    private Long id;

    @ApiModelProperty(value = "이름", required = true)
    private String name;

    @ApiModelProperty(value = "별명", required = true)
    private String nickname;

    @ApiModelProperty(value = "전화번호", required = true)
    private String phoneNumber;

    @ApiModelProperty(value = "이메일", required = true)
    private String email;

    @ApiModelProperty(value = "성별")
    private String sex;
}
