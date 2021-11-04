package com.back.shop.user;

import com.back.shop.security.JwtTokenProvider;
import com.back.shop.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@Api("User")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/join")
    @ApiOperation(value = "회원 가입")
    public UserResponse joinUser(@RequestBody UserJoinRequest userJoinRequest) {
        User user = userService.userJoin(userJoinRequest);

        return UserResponseBuilder.one(user);
    }

    @PostMapping("/login")
    @ApiOperation(value = "회원 로그인(인증)")
    public String login(@RequestBody UserLoginRequest userLoginRequest) {
        User user = userService.userLogin(userLoginRequest);

        return jwtTokenProvider.createToken(userLoginRequest.getEmail(), new ArrayList<>(Collections.singleton(user.getAuth())));
    }

    @PostMapping("logout")
    @ApiOperation(value = "회원 로그아웃")
    public void logout() {

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "단일 회원 상세 정보 조회")
    public void getUser(@PathVariable String id) {

    }

    @GetMapping("/{id}/order")
    @ApiOperation(value = "단일 회원의 주문 목록 조회")
    public void getOrders(@PathVariable String id) {

    }

    @GetMapping
    @ApiOperation(value = "여러 회원 목록 조회")
    public String getUsers() {
        return "abc";
    }

}
