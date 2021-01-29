package com.example.greeting.core;

/**
 * Enum for handling allowed time based greetings
 *
 * @author Dario Šiprak
 * @version 0.03.002
 * @since 29.01.2021.
 */
public enum TimeBasedGreeting {
    GOOD_MORNING("Good morning"),
    GOOD_AFTERNOON("Good afternoon"),
    GOOD_EVENING("Good evening"),
    GOOD_NIGHT("Good night"),
    UNKNOWN(""),
    ;

    private final String timeBasedGreeting;

    TimeBasedGreeting(String timeBasedGreeting) {
        this.timeBasedGreeting = timeBasedGreeting;
    }

    public String getTimeBasedGreeting() {
        return timeBasedGreeting;
    }

    /**
     * Returns a TimeBasedGreeting type enum for the provided greeting
     *
     * @param greeting  Provided greeting
     * @return Matching TimeBasedGreeting type or UNKNOWN if it is not one of the known greeting types
     */
    public static TimeBasedGreeting fromValue(String greeting) {
        for(TimeBasedGreeting timeBasedGreetingValue : TimeBasedGreeting.values()) {
            if(timeBasedGreetingValue.getTimeBasedGreeting().equals(greeting)) {
                return timeBasedGreetingValue;
            }
        }
        return UNKNOWN;
    }
}
