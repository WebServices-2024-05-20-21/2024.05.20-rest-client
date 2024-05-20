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

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();


        /************ GET ************/
        /*String uri = "http://localhost:8080/test4";
        Car car = restTemplate.getForObject(uri, Car.class);
        System.out.println(car.getId());
        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getPlate());*/

        /************* POST *************/
        /*String uri = "http://localhost:8080/test10";
        Car car = new Car(11, "Honda", "Civic", "KR987");
        Car responseCar = restTemplate.postForObject(uri, car, Car.class);
        System.out.println(responseCar.getId());
        System.out.println(responseCar.getBrand());
        System.out.println(responseCar.getModel());
        System.out.println(responseCar.getPlate());*/

        /************* EXCHANGE **************/
        String uri = "http://localhost:8080/test8/{age}";

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("age", "46");

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("name", "Janusz")
                .queryParam("surname", "Kowalski")
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header1", "jakas wartosc");
        httpHeaders.add("header2", "jakas inna wartosc!");

        Car car = new Car(11, "Honda", "Civic", "KR987");

        HttpEntity<Car> request = new HttpEntity<>(car, httpHeaders);

        ResponseEntity<Car> response = restTemplate.exchange(uriComponents.toUriString(),
                HttpMethod.PUT,
                request,
                Car.class,
                pathVariables);

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCode().value());
        System.out.println(response.getStatusCodeValue());

        HttpHeaders responseHeaders = response.getHeaders();
        for(Map.Entry<String, List<String>> header : responseHeaders.entrySet()) {
            System.out.println(header.getKey() + " - " + header.getValue());
        }

        Car responseCar = response.getBody();
        System.out.println(responseCar.getId());
        System.out.println(responseCar.getBrand());
        System.out.println(responseCar.getModel());
        System.out.println(responseCar.getPlate());

        RestApiClient restApiClient = new RestApiClient();
        Optional<Car> c1 = restApiClient.turboPutEndpoint(44, "Wiesiek", "Malinowski",
                "H1", "H2", new Car());

        Optional<Car> c2 = restApiClient.turboPutEndpoint(30, "Karol", "Kowalski",
                "asdfg", "sdfg", new Car());
    }
}
