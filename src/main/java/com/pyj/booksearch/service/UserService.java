package com.pyj.booksearch.service;

import com.pyj.booksearch.dto.BookDTO;
import com.pyj.booksearch.dto.History;
import com.pyj.booksearch.dto.User;
import com.pyj.booksearch.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String join(User user){
        BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
        user.setUid("mellow");
        user.setPassword("1234");
        user.setPassword(pwEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/user/login";
    }


}
