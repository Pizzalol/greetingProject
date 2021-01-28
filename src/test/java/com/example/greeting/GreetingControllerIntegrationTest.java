package com.example.greeting;

import com.example.greeting.controller.GreetingController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.greeting.core.GreetingConstants.GREETING_ENDPOINT;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes = GreetingApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class GreetingControllerIntegrationTest {

    private HttpClient httpClient;

    private String basePath;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        basePath = "http://localhost:" + port + GREETING_ENDPOINT;
        httpClient = HttpClient.newHttpClient();
    }

    @Test
    @DisplayName("Should return the correct greeting")
    public void shouldReturnTheCorrectGreeting() throws Exception {
        // given
        var uri = UriComponentsBuilder.fromHttpUrl(basePath)
                .queryParam("name", "Leonard")
                .build()
                .toUri();

        var httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        // when
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // then
        assertEquals(200, response.statusCode());
        assertEquals("Hi, Leonard!", response.body());
    }

}
