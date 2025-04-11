package com.own.kafka_producer_app.controller;

import com.own.kafka_producer_app.service.KafkaMessgePublisher;
import dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Input {

    @Autowired
    private KafkaMessgePublisher kafkaMessgePublisher;

    @GetMapping("h")
    public String test() {

        return "Hello Kafka";
    }

    @GetMapping("/Publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {

        try {
            kafkaMessgePublisher.send(message);
            return ResponseEntity.ok("Message sent");

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }
    }

    @PostMapping("/insert")
    public ResponseEntity<?> sendEvents(@RequestBody Customer customer){

        try {

            kafkaMessgePublisher.sendEventTopic(customer);
            return ResponseEntity.ok("Message successfully sent");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
