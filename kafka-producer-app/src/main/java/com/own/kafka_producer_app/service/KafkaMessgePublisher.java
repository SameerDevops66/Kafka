package com.own.kafka_producer_app.service;

import dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessgePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;   // Key - String | Value - Object


    public void send(String message) {
        CompletableFuture<SendResult<String, Object>> variable = kafkaTemplate.send("sameer1", message);
        variable.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message: [" + message + "] with offset [" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }


        });
    }

    public void sendEventTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> variable = kafkaTemplate.send("sameer1", customer);
            variable.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message: [" + customer.toString() + "] with offset [" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" + customer.toString() + "] due to : " + ex.getMessage());
                }


            });

        } catch (Exception e) {

            System.out.println("Unable to send message=[" + customer.toString() + "] due to : " + e.getMessage());
        }


    }

}
