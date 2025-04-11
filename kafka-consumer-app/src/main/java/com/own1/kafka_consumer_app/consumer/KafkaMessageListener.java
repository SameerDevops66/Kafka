package com.own1.kafka_consumer_app.consumer;

import dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

//    @RetryableTopic(attempts = "4") //n-1
//    @KafkaListener(topics = "sameer1" , groupId = "sameer-jk")
//    public void consume(String message) {
//
//        log.info("Consumed the message {} ", message);
//
//
//    }

    @KafkaListener(topics = "sameer1" , groupId = "sameer-jk")
    public void consumer(Customer customer) {

        log.info("Consumed the message {} ", customer.toString());


    }

//    @DltHandler
//    public void listenDLT(String message) {
//        log.info("Listening DLT {}", message);
//    }
}
