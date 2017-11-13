package com.example.billing;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import com.example.payments.Gateway;

public class BillingMessageReceiver {

    private final Gateway paymentGateway;

    public BillingMessageReceiver(Gateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    //@RabbitListener(queues = "billing-queue")
    @RabbitListener(queues = "${billingQueueName}")
    public void process(BillingMessage message) {

        if (paymentGateway.createReocurringPayment(message.getAmount())) {
            System.out.println("BILLING-QUEUE-Read Message");
        } else {
            System.out.println("BILLING-QUEUE-Failed");
        }
    }
}
