package com.frankmoley.boot.landon.roomwebapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogingController {
    @GetMapping("/login")
    public String getLoggingPage(){
        return "login";
    }
}
