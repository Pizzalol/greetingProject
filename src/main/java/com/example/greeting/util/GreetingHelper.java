package com.example.greeting.util;

import com.example.greeting.core.Greeting;

public class GreetingHelper {

    public static boolean validateGreeting(String providedGreeting) {
        Greeting greeting = Greeting.fromValue(providedGreeting);

        if(greeting.getGreeting().equals(Greeting.UNKNOWN.getGreeting())) return false;

        return true;
    }
}
