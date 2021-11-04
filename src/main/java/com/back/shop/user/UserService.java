package com.back.shop.user;

import com.back.shop.user.domain.UserInfo;
import com.back.shop.user.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void userJoin(UserJoinRequest userJoinRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserInfo userInfo = new UserInfo(userJoinRequest.getName(), userJoinRequest.getNickname(),
                passwordEncoder.encode(userJoinRequest.getPassword()),
                userJoinRequest.getPhoneNumber(), userJoinRequest.getEmail(),
                userJoinRequest.getSex());

        userRepository.save(userInfo.toEntity());
    }

}
