package com.back.shop.user.domain;

import java.util.regex.Pattern;

public class Email {

    private final String address;

    public Email(String address) {
        this.address = validateEmail(address);
    }

    private String validateEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email not null");
        }

        if (email.length() > 100) {
            throw new IllegalArgumentException("Email max length 100 input : " + email);
        }

        if (!Pattern.matches("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+", email)) {
            throw new IllegalArgumentException("xxx@xxx.xxx : " + email);
        }

        return email;
    }

    @Override
    public String toString() {
        return address;
    }
}
