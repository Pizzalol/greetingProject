package com.example.greeting.core;

/**
 * Enum for handling allowed greetings
 *
 * @author Dario Šiprak
 * @version 0.02.000
 * @since 28.01.2021.
 */
public enum Greeting {

    HELLO("Hello"),
    HI("Hi"),
    HEY("Hey"),
    UNKNOWN("")
    ;

    private final String greeting;

    Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    /**
     * Returns a Greeting type enum for the provided greeting
     *
     * @param greeting  Provided greeting
     * @return Matching Greeting type or UNKNOWN if it is not one of the known greeting types
     */
    public static Greeting fromValue(String greeting) {
        for(Greeting greetingValue : Greeting.values()) {
            if(greetingValue.getGreeting().equals(greeting)) {
                return greetingValue;
            }
        }
        return UNKNOWN;
    }
}
