package com.example.greeting.core;

import com.example.greeting.configuration.Configuration;
import com.example.greeting.util.GreetingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.example.greeting.core.GreetingConstants.TIME_BASED_GREETING;

/**
 * TimeBasedGreeterComponent is a class that has the ability to create
 * time based greetings
 *
 * @author Dario Šiprak
 * @version 0.03.002
 * @since 29.01.2021.
 * @see Greeter
 */
@Component
@ConditionalOnProperty(name = "greeter.mode", havingValue = TIME_BASED_GREETING)
public class TimeBasedGreeterComponent implements Greeter{

    @Override
    public String greet(String name) {
        return GreetingHelper.getTimeBasedGreeting() + ", " + name + "!";
    }
}
