package com.back.shop.user;

import com.back.shop.order.entity.Order;
import com.back.shop.order.entity.OrderRepository;
import com.back.shop.user.domain.UserInfo;
import com.back.shop.user.entity.User;
import com.back.shop.user.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.InputMismatchException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public User userJoin(UserJoinRequest userJoinRequest) {
        UserInfo userInfo = new UserInfo(userJoinRequest.getName(), userJoinRequest.getNickname(),
                encodePassword(userJoinRequest.getPassword()), userJoinRequest.getPhoneNumber(), userJoinRequest.getEmail(),
                userJoinRequest.getSex());

        return userRepository.save(userInfo.toEntity());
    }

    @Transactional(readOnly = true)
    public User userLogin(UserLoginRequest userLoginRequest) {
        User user = loadUserByUsername(userLoginRequest.getEmail());

        if (!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
            throw new InputMismatchException("Mismatch password. email : " + userLoginRequest.getEmail());
        }

        return user;
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {

        return userRepository.findById(id).orElseThrow(() -> new InputMismatchException("user id not found. id :" + id));
    }

    @Transactional(readOnly = true)
    public List<Order> getOrders(Long userId) {

        return orderRepository.findByUserId(userId);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findFirstByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found. email : " + email));
    }
}
