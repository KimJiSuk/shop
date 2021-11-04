package com.back.shop.domain;

import java.util.regex.Pattern;

public class User {
    private final int NAME_MAX_LENGTH = 20;
    private final int NICKNAME_MAX_LENGTH = 30;
    private final int PHONE_NUMBER_MAX_LENGTH = 20;
    private final int EMAIL_MAX_LENGTH = 100;

    private final String NAME_REGULAR_REGEX = "^[ㄱ-ㅎ가-힣a-zA-Z]*$";
    private final String NICKNAME_REGULAR_REGEX = "^[a-z]*$";
    private final String PHONE_NUMBER_REGULAR_REGEX = "^[0-9]*$";
    private final String EMAIL_REGULAR_REGEX = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
    private final String name;
    private final String nickname;
    private final String password;
    private final String phoneNumber;
    private final String email;
    private final String sex;

    public User(String name, String nickname, String password, String phoneNumber, String email, String sex) {
        this.name = validateName(name);
        this.nickname = validateNickname(nickname);
        this.password = password;
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.email = validateEmail(email);
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    private String validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("User Name max length 20. input : " + name);
        }

        if (!Pattern.matches(NAME_REGULAR_REGEX, name)) {
            throw new IllegalArgumentException("User Name is 한글, 영대소문자 : " + name);
        }

        return name;
    }

    private String validateNickname(String nickname) {
        if (nickname.length() > NICKNAME_MAX_LENGTH) {
            throw new IllegalArgumentException("NickName max length 30. input : " + nickname);
        }

        if (!Pattern.matches(NICKNAME_REGULAR_REGEX, nickname)) {
            throw new IllegalArgumentException("NickName is 영소문자 : " + nickname);
        }

        return nickname;
    }

    private String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > PHONE_NUMBER_MAX_LENGTH) {
            throw new IllegalArgumentException("Phone Number max length 20 input : " + phoneNumber);
        }

        if (!Pattern.matches(PHONE_NUMBER_REGULAR_REGEX, phoneNumber)) {
            throw new IllegalArgumentException("Phone Number is 숫자 : " + phoneNumber);
        }

        return phoneNumber;
    }

    private String validateEmail(String email) {
        if (email.length() > EMAIL_MAX_LENGTH) {
            throw new IllegalArgumentException("Email max length 100 input : " + email);
        }

        if (!Pattern.matches(EMAIL_REGULAR_REGEX, email)) {
            throw new IllegalArgumentException("xxx@xxx.xxx : " + email);
        }

        return email;
    }
}
