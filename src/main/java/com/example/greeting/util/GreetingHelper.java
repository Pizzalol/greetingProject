package com.example.greeting.util;

import com.example.greeting.core.Greeting;
import com.example.greeting.core.TimeBasedGreeting;

import java.util.Calendar;

/**
 * GreetingHelper is a class that contains all the necessary methods used in greetings
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

    /**
     * Checks the current time of day and returns a valid greeting for that time period
     *
     * @return String containing the valid greeting
     * @see TimeBasedGreeting
     */
    public static String getTimeBasedGreeting() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if(hour >= 3 && hour < 12) {
            return TimeBasedGreeting.GOOD_MORNING.getTimeBasedGreeting();
        } else if(hour >= 12 && hour < 17) {
            return TimeBasedGreeting.GOOD_AFTERNOON.getTimeBasedGreeting();
        } else if(hour >= 17 && hour < 20) {
            return TimeBasedGreeting.GOOD_EVENING.getTimeBasedGreeting();
        } else if(hour >= 20 || hour < 3) {
            return TimeBasedGreeting.GOOD_NIGHT.getTimeBasedGreeting();
        }
        return TimeBasedGreeting.UNKNOWN.getTimeBasedGreeting();
    }
}
