package com.back.shop.domain;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void joinUser() {
        User user = new User("name", "nickname", "pass", "01020650301",
                "yes0229@gmail.com", "M");
    }
}
