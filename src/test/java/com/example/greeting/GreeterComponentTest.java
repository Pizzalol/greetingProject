package com.example.greeting;

import com.example.greeting.configuration.Configuration;
import com.example.greeting.configuration.ConfigurationTest;
import com.example.greeting.core.GreeterComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class GreeterComponentTest {

    @Mock
    private Configuration configuration;

    @InjectMocks
    public GreeterComponent greeterComponent;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void greet_ValidGreeting_CorrectGreetingReturned() {
        System.out.println("-> greet_ValidGreeting_CorrectGreetingReturned running...");

        when(configuration.getGreeting()).thenReturn("Hey");

        String greeting = greeterComponent.greet("Dario");
        Assertions.assertEquals("Hey, Dario!", greeting);
        verify(configuration, times(2)).getGreeting();
    }

    @Test(expected = ResponseStatusException.class)
    public void greet_GreetThrowsException_InvalidGreetingConfiguration() {
        System.out.println("-> greet_GreetThrowsException_InvalidGreetingConfiguration");

        when(configuration.getGreeting())
                .thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST));

        greeterComponent.greet("Dario");

        verify(configuration, times(2)).getGreeting();
    }
}
