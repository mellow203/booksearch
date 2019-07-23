package com.pyj.booksearch.controller;

import com.pyj.booksearch.dto.User;
import com.pyj.booksearch.jpa.UserRepository;
import com.pyj.booksearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    private final  UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public String join(User user){
        return this.userService.join(user);

    }
}