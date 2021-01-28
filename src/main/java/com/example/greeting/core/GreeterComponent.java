package com.example.greeting.core;

import com.example.greeting.configuration.Configuration;
import com.example.greeting.util.GreetingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


/**
 * GreeterComponent is a class that has the ability to create greetings based on the active configuration profile
 *
 * @author Dario Šiprak
 * @version 0.03.000
 * @since 28.01.2021.
 * @see Greeter
 */
@Component
public class GreeterComponent implements Greeter{

    @Autowired
    private Configuration configuration;

    @Override
    public String greet(String name) {
        if(GreetingHelper.validateGreeting(configuration.getGreeting())) {
            return configuration.getGreeting() + ", " + name + "!";
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid greeting used!");
        }
    }
}
