package com.example.greeting.core;


/**
 * Interface for allowing different greeting implementations
 *
 * @author Dario Šiprak
 * @version 0.03.000
 * @since 28.01.2021.
 */
public interface Greeter {
    String greet(String name);
}
