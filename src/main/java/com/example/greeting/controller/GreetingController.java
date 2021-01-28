package com.example.greeting.controller;

import com.example.greeting.configuration.Configuration;
import com.example.greeting.core.Greeter;
import com.example.greeting.util.GreetingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.greeting.core.GreetingConstants.GREETING_ENDPOINT;

/**
 * REST controller containing all the greeting operations
 *
 * @author Dario Šiprak
 * @version 0.01.000
 * @since 28.01.2021.
 */
@RestController
public class GreetingController {

    @Autowired
    Greeter greeter;


    /**
     * GET operation endpoint for greeting the user
     *
     * @param name  User's name
     * @return  A string containing the provided name and a greeting based on the active configuration
     */
    @GetMapping(value = GREETING_ENDPOINT)
    public String greetUser(@RequestParam(name = "name", defaultValue = "Dario") String name) {

        return greeter.greet(name);
    }
}
