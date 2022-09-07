package com.userinfo.userinfo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @GetMapping("/user")
    public String getUser(){
        return "My Name  Is Nilesh";
    }
}
