package com.lynda.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
    @Bean
    public String getGrettings(){
        return "Hello World";
    }

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext();
        Strcontext.getBean("getGrettings");
    }
}
