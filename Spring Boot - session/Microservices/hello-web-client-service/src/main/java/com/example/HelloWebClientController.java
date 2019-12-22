package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;


@Controller
public class HelloWebClientController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String handleRequest(Model model) {
        //accessing hello-service
        HelloObject helloObject = restTemplate.getForObject("http://hello-service/hello", HelloObject.class);
        model.addAttribute("msg", helloObject.getMessage());
        model.addAttribute("time", LocalDateTime.now());
        return "hello-page";
    }
}