package com.paypal.payments.controller;

import com.paypal.payments.dto.UserDto;
import com.paypal.payments.entity.User;
import com.paypal.payments.mapper.UserMapper;
import com.paypal.payments.service.abstraction.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        User user = UserMapper.MAPPER.mapDtoToUser(userDto);
        User obtainedUser = userService.registerUser(user.getUserName(), user.getPassword(), user.getEmail());
        return ResponseEntity.ok(UserMapper.MAPPER.mapUserToDto(obtainedUser));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userName) {
        return ResponseEntity.ok(UserMapper.MAPPER.mapUserToDto(userService.findByUserName(userName)));
    }
}
