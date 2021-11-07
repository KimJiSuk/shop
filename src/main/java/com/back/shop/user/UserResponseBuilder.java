package com.back.shop.user;

import com.back.shop.user.entity.User;

public class UserResponseBuilder {

    public static UserResponse one(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .sex(user.getSex())
                .build();
    }
}
