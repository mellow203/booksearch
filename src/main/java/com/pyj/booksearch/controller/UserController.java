package com.pyj.booksearch.controller;

import com.pyj.booksearch.dto.User;
import com.pyj.booksearch.jpa.UserRepository;
import com.pyj.booksearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    private final  UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping("/signUp")
    public ModelAndView signUp(){
        return new ModelAndView("join");
    }

    @PostMapping("/join")
    public ModelAndView join(User user){
        return new ModelAndView("login");
    }
}
