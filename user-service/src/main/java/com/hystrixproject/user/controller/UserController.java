package com.hystrixproject.user.controller;

import com.hystrixproject.user.VO.ResponseTemplateVO;
import com.hystrixproject.user.entity.User;
import com.hystrixproject.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserwithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserwithDepartment of UserController");
        return userService.getUserwithDepartment(userId);
    }
}
