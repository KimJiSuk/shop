package com.back.shop.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api("User")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    @ApiOperation(value = "회원 가입")
    public void joinUser(@RequestBody UserJoinRequest userJoinRequest) {
        System.out.println(userJoinRequest);
    }

    @PostMapping("/login")
    @ApiOperation(value = "회원 로그인(인증)")
    public void login() {

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
    public void getUsers() {

    }

}
