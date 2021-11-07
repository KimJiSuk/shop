package com.back.shop.user.domain;

import com.back.shop.user.entity.User;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class UserInfo {
    private final String USER_ROLE = "ROLE_USER";
    private final int NAME_MAX_LENGTH = 20;
    private final int NICKNAME_MAX_LENGTH = 30;
    private final int PASSWORD_MIN_LENGTH = 10;
    private final int PHONE_NUMBER_MAX_LENGTH = 20;
    private final int EMAIL_MAX_LENGTH = 100;

    private final String NAME_REGULAR_REGEX = "^[ㄱ-ㅎ가-힣a-zA-Z]*$";
    private final String NICKNAME_REGULAR_REGEX = "^[a-z]*$";
    private final String PHONE_NUMBER_REGULAR_REGEX = "^[0-9]*$";

    private final String name;
    private final String nickname;
    private final String password;
    private final String phoneNumber;
    private final Email email;
    private final String sex;

    public UserInfo(String name, String nickname, String password, String phoneNumber, String email, String sex) {
        this.name = validateName(name);
        this.nickname = validateNickname(nickname);
        this.password = validatePassword(password);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.email = new Email(email);
        this.sex = sex;
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

    private String validatePassword(String password) {
        if (password.length() < PASSWORD_MIN_LENGTH) {
            throw new IllegalArgumentException("Password min length 10.");
        }

        return password;
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

    public User toEntity() {
        return User.builder()
                .name(name)
                .nickname(nickname)
                .password(password)
                .phoneNumber(phoneNumber)
                .email(email.toString())
                .sex(sex)
                .auth(USER_ROLE)
                .build();
    }
}
