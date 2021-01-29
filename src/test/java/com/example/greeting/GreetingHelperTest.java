package com.example.greeting;

import com.example.greeting.core.GreeterComponent;
import com.example.greeting.core.TimeBasedGreeterComponent;
import com.example.greeting.core.TimeBasedGreeting;
import com.example.greeting.util.GreetingHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Calendar;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(PowerMockRunner.class)
public class GreetingHelperTest {

    @Mock
    Calendar calendar;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getTimeBasedGreeting_TimeIs3AM_GoodMorningReturned() {
        System.out.println("-> getTimeBasedGreeting_TimeIs3AM_GoodMorningReturned running...");

        try(MockedStatic<Calendar> mockedCalendar = mockStatic(Calendar.class)) {
            mockedCalendar
                    .when(Calendar::getInstance)
                    .thenReturn(calendar);
            when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(3);
            String greeting = GreetingHelper.getTimeBasedGreeting();
            Assertions.assertEquals(TimeBasedGreeting.GOOD_MORNING.getTimeBasedGreeting(), greeting);
        }
    }

    @Test
    public void getTimeBasedGreeting_TimeIs12PM_GoodAfternoonReturned() {
        System.out.println("-> getTimeBasedGreeting_TimeIs12PM_GoodAfternoonReturned running...");

        try(MockedStatic<Calendar> mockedCalendar = mockStatic(Calendar.class)) {
            mockedCalendar
                    .when(Calendar::getInstance)
                    .thenReturn(calendar);
            when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(12);
            String greeting = GreetingHelper.getTimeBasedGreeting();
            Assertions.assertEquals(TimeBasedGreeting.GOOD_AFTERNOON.getTimeBasedGreeting(), greeting);
        }
    }

    @Test
    public void getTimeBasedGreeting_TimeIs5PM_GoodEveningReturned() {
        System.out.println("-> getTimeBasedGreeting_TimeIs5PM_GoodEveningReturned running...");

        try(MockedStatic<Calendar> mockedCalendar = mockStatic(Calendar.class)) {
            mockedCalendar
                    .when(Calendar::getInstance)
                    .thenReturn(calendar);
            when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(17);
            String greeting = GreetingHelper.getTimeBasedGreeting();
            Assertions.assertEquals(TimeBasedGreeting.GOOD_EVENING.getTimeBasedGreeting(), greeting);
        }
    }

    @Test
    public void getTimeBasedGreeting_TimeIs8PM_GoodNightReturned() {
        System.out.println("-> getTimeBasedGreeting_TimeIs8PM_GoodNightReturned running...");

        try(MockedStatic<Calendar> mockedCalendar = mockStatic(Calendar.class)) {
            mockedCalendar
                    .when(Calendar::getInstance)
                    .thenReturn(calendar);
            when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(20);
            String greeting = GreetingHelper.getTimeBasedGreeting();
            Assertions.assertEquals(TimeBasedGreeting.GOOD_NIGHT.getTimeBasedGreeting(), greeting);
        }
    }
}
