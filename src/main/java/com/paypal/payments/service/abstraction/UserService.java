package com.paypal.payments.service.abstraction;

import com.paypal.payments.entity.User;

public interface UserService {
    User registerUser(String userName, String password, String email);
    User findByUserName(String userName);
}
