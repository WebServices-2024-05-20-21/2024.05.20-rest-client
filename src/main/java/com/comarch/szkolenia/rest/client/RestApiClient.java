package com.comarch.szkolenia.rest.client;

import com.comarch.szkolenia.rest.client.model.Car;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RestApiClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public Optional<Car> turboPutEndpoint(int age, String name, String surname, String h1, String h2, Car car) {
        String uri = "http://localhost:8080/test8/{age}";

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("age", Integer.toString(age));

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("name", name)
                .queryParam("surname", surname)
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header1", h1);
        httpHeaders.add("header2", h2);

        HttpEntity<Car> request = new HttpEntity<>(car, httpHeaders);

        ResponseEntity<Car> response = restTemplate.exchange(uriComponents.toUriString(),
                HttpMethod.PUT,
                request,
                Car.class,
                pathVariables);

        if(response.getStatusCode().value() != 200) {
            return Optional.empty();
        }
        return Optional.of(response.getBody());
    }
}
