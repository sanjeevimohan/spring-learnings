package com.example.billing;

import com.example.payments.Gateway;
import com.example.payments.RecurlyGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class BillingApplication {

	@Value("${billingQueueName}")
	String billingQueueName;

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}

	@Bean
	Gateway paymentGateway() {
		return new RecurlyGateway();
	}

	@Bean
	Queue queue() {
		return new Queue(billingQueueName, false);
	}

	@Bean
	MessageListenerAdapter listenerAdapter(BillingMessageReceiver receiver) {
		return new MessageListenerAdapter(receiver, "process");
	}

	@Bean
	BillingMessageReceiver receiver(Gateway paymentGateway) {
		return new BillingMessageReceiver(paymentGateway);
	}
}
