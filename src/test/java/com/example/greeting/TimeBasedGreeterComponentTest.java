package com.example.greeting;

import com.example.greeting.configuration.Configuration;
import com.example.greeting.core.GreeterComponent;
import com.example.greeting.core.TimeBasedGreeterComponent;
import com.example.greeting.core.TimeBasedGreeting;
import com.example.greeting.util.GreetingHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest(properties = "greeter.mode=timeBasedGreeting")
@RunWith(PowerMockRunner.class)
public class TimeBasedGreeterComponentTest {

    public TimeBasedGreeterComponent greeterComponent;


    @Before
    public void setUp() {
        greeterComponent = new TimeBasedGreeterComponent();
    }


    @Test
    public void greet_ValidGreeting_GoodMorningReturned() {
        System.out.println("-> greet_ValidGreeting_GoodMorningReturned running...");

        try(MockedStatic<GreetingHelper> mockedGreetingHelper = mockStatic(GreetingHelper.class)) {
            mockedGreetingHelper
                    .when(GreetingHelper::getTimeBasedGreeting)
                    .thenReturn(TimeBasedGreeting.GOOD_MORNING.getTimeBasedGreeting());
            String greeting = greeterComponent.greet("Dario");
            Assertions.assertEquals("Good morning, Dario!", greeting);
            mockedGreetingHelper.verify(GreetingHelper::getTimeBasedGreeting);
        }
    }

    @Test
    public void greet_ValidGreeting_GoodAfternoonReturned() {
        System.out.println("-> greet_ValidGreeting_GoodAfternoonReturned running...");

        try(MockedStatic<GreetingHelper> mockedGreetingHelper = mockStatic(GreetingHelper.class)) {
            mockedGreetingHelper
                    .when(GreetingHelper::getTimeBasedGreeting)
                    .thenReturn(TimeBasedGreeting.GOOD_AFTERNOON.getTimeBasedGreeting());
            String greeting = greeterComponent.greet("Dario");
            Assertions.assertEquals("Good afternoon, Dario!", greeting);
            mockedGreetingHelper.verify(GreetingHelper::getTimeBasedGreeting);
        }
    }

    @Test
    public void greet_ValidGreeting_GoodEveningReturned() {
        System.out.println("-> greet_ValidGreeting_GoodEveningReturned running...");

        try(MockedStatic<GreetingHelper> mockedGreetingHelper = mockStatic(GreetingHelper.class)) {
            mockedGreetingHelper
                    .when(GreetingHelper::getTimeBasedGreeting)
                    .thenReturn(TimeBasedGreeting.GOOD_EVENING.getTimeBasedGreeting());
            String greeting = greeterComponent.greet("Dario");
            Assertions.assertEquals("Good evening, Dario!", greeting);
            mockedGreetingHelper.verify(GreetingHelper::getTimeBasedGreeting);
        }
    }

    @Test
    public void greet_ValidGreeting_GoodNightReturned() {
        System.out.println("-> greet_ValidGreeting_GoodNightReturned running...");

        try(MockedStatic<GreetingHelper> mockedGreetingHelper = mockStatic(GreetingHelper.class)) {
            mockedGreetingHelper
                    .when(GreetingHelper::getTimeBasedGreeting)
                    .thenReturn(TimeBasedGreeting.GOOD_NIGHT.getTimeBasedGreeting());
            String greeting = greeterComponent.greet("Dario");
            Assertions.assertEquals("Good night, Dario!", greeting);
            mockedGreetingHelper.verify(GreetingHelper::getTimeBasedGreeting);
        }
    }
}
