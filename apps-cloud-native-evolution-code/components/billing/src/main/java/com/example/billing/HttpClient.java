package com.example.billing;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class HttpClient {

    private final RestOperations restTemplate;
    //private final String serviceEndpoint;

    //public Client(String serviceEndpoint) {
    public HttpClient(RestTemplate restTemplate) {
        //this.restTemplate = new RestTemplate();
        this.restTemplate = restTemplate;
        //this.serviceEndpoint = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "billUserFallback")
    public void billUser(String userId, int amount) {
        //restTemplate.postForEntity(serviceEndpoint + "/reocurringPayment", amount, String.class);


        restTemplate.postForEntity("//billing/reocurringPayment", amount, String.class);
    }

    public void billUserFallback(String userId, int amount) {
        System.out.println("Executing fallback method for user: " + userId + " and amount: " + amount);
    }
}
