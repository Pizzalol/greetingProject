package com.example.greeting.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Configuration class for the dev profile
 *
 * @author Dario Šiprak
 * @version 0.02.000
 * @since 28.01.2021.
 * @see Configuration
 */

@Component
@Profile("dev")
public class ConfigurationDev implements Configuration{

    @Value("${greeting.user.greeting}")
    private String greeting;

    @Override
    public String getGreeting() {
        return this.greeting;
    }
}
