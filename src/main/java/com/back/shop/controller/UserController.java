package com.back.shop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api("User")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @PostMapping
    @ApiOperation(value = "회원 가입")
    public void joinUser() {

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

    @GetMapping()
    @ApiOperation(value = "여러 회원 목록 조회")
    public void getUsers() {

    }

}
