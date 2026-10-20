package com.mycode.product.controller;

import com.mycode.product.entity.User;
import com.mycode.product.repository.UserRepository;
import com.mycode.product.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyUserDetailsService service;
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.createUser(user);
    }

}
