package com.back.shop.domain;

import com.back.shop.user.domain.UserInfo;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void joinUser() {
        UserInfo user = new UserInfo("name", "nickname", "pass", "01020650301",
                "yes0229@gmail.com", "M");
    }
}
