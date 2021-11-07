package com.back.shop.user;

import com.back.shop.order.OrderResponse;
import com.back.shop.order.OrderResponseBuilder;
import com.back.shop.order.entity.Order;
import com.back.shop.security.JwtTokenProvider;
import com.back.shop.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.back.shop.ApiUtils.ApiResult;
import static com.back.shop.ApiUtils.success;

@Api("User")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/join")
    @ApiOperation(value = "회원 가입")
    public ApiResult<UserResponse> joinUser(@RequestBody UserJoinRequest userJoinRequest) {
        User user = userService.userJoin(userJoinRequest);

        return success(UserResponseBuilder.one(user));
    }

    @PostMapping("/login")
    @ApiOperation(value = "회원 로그인(인증)")
    public ApiResult<Map<String, String>> login(@RequestBody UserLoginRequest userLoginRequest) {
        User user = userService.userLogin(userLoginRequest);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwtTokenProvider.createToken
                (userLoginRequest.getEmail(), new ArrayList<>(Collections.singleton(user.getAuth()))));

        return success(map);
    }

    @PostMapping("logout")
    @ApiOperation(value = "회원 로그아웃")
    public void logout() {

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "단일 회원 상세 정보 조회")
    public ApiResult<UserResponse> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);

        return success(UserResponseBuilder.one(user));
    }

    @GetMapping("/{id}/order")
    @ApiOperation(value = "단일 회원의 주문 목록 조회")
    public ApiResult<List<OrderResponse>> getOrders(@PathVariable Long id) {
        List<Order> orders = userService.getOrders(id);

        return success(OrderResponseBuilder.of(orders));
    }

    @GetMapping
    @ApiOperation(value = "여러 회원 목록 조회")
    public ApiResult<List<UserOrderResponse>> getUsers(
            @RequestParam Long offset,
            @RequestParam Long size,
            @RequestParam String name,
            @RequestParam String email
    ) {

        return success(UserOrderResponseBuilder.of(userService.getUsers(offset, size, name, email)));
    }

}
