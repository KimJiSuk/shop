package com.back.shop.domain;

import com.back.shop.user.domain.UserInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void joinUser() {
        UserInfo user = new UserInfo("name", "nickname", "password1234", "01020650301",
                "yes0229@gmail.com", "M");
    }

    @Test
    public void joinUserEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    UserInfo user = new UserInfo("name", "nickname", "pass", "01020650301",
                            "yes0229@gmailcom", "M");
                });
    }
}
