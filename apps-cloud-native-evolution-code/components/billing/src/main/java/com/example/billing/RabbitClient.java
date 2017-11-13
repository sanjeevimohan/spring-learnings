package com.example.billing;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import org.springframework.web.client.RestOperations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitClient {

    private final String queueName;
    private final RabbitTemplate rabbitTemplate;

    public RabbitClient(String queueName, RabbitTemplate rabbitTemplate) {
        this.queueName = queueName;
        this.rabbitTemplate = rabbitTemplate;
    }

    @HystrixCommand(fallbackMethod = "billUserFallback")
    public void billUser(String userId, int amount) {
        rabbitTemplate.convertAndSend(queueName, new BillingMessage(userId, amount));
    }

    public void billUserFallback(String userId, int amount) {
        System.out.println("Executing fallback method for user: " + userId + " and amount: " + amount);
    }
}
