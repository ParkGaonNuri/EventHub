//package com.kbhc.EventHub;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@AllArgsConstructor
//public class KafkaProducer {
//    private final KafkaTemplate<String, ProducerMessage> kafkaTemplate;
//
//    public void send(ProducerMessage producerMessage) {
//        kafkaTemplate.send(kafkaTemplate.getDefaultTopic(), producerMessage);
//        log.info("Published message to kafka queue: {}", producerMessage.getMessage());
//    }
//
//}
