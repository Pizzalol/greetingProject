package com.example.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.example.greeting.core.GreetingConstants.GREETING_ENDPOINT;

@RestController
public class GreetingController {


    @GetMapping(value = GREETING_ENDPOINT)
    public String greetUser(HttpServletRequest request, @RequestParam("name") String name) {
        return "Hi, " + name + "!";
    }
}
