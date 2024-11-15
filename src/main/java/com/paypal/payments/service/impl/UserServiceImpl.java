package com.paypal.payments.service.impl;

import com.paypal.payments.entity.User;
import com.paypal.payments.exceptions.NoSuchUserException;
import com.paypal.payments.repository.UserRepository;
import com.paypal.payments.service.abstraction.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(String userName, String password, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        return userRepository.save(user);
    }

    public User findByUserName(String userName) {
        System.out.println(userRepository.findByUserName(userName).get());
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new NoSuchUserException(userName));
    }
}
