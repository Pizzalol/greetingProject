package com.example.greeting.util;

import com.example.greeting.core.Greeting;

/**
 * GreetingHelper is a class that contains all the necessary validation methods used in greetings
 *
 * @author Dario Šiprak
 * @version 0.02.000
 * @since 28.01.2021.
 */
public class GreetingHelper {

    /**
     * Checks if the provided greeting is among the allowed greeting types
     *
     * @param providedGreeting  Provided greeting
     * @return boolean - true if the greeting is allowed, false if not
     * @see Greeting
     */
    public static boolean validateGreeting(String providedGreeting) {
        Greeting greeting = Greeting.fromValue(providedGreeting);

        if(greeting.getGreeting().equals(Greeting.UNKNOWN.getGreeting())) return false;

        return true;
    }
}
