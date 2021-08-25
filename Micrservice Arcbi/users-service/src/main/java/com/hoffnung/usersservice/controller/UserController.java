package com.hoffnung.usersservice.controller;

import com.hoffnung.usersservice.VO.ResponseTemplateVo;
import com.hoffnung.usersservice.entity.User;
import com.hoffnung.usersservice.service.UserService;
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
    public User saveUser(@RequestBody  User user){
        log.info("Inside Save Useer of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id")  Long userId){
        log.info("Inside Save getUserWithDepartment of UserController");
        return  userService.getUserWithDepartment(userId);
    }



}
