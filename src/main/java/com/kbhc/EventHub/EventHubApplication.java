package com.kbhc.EventHub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class EventHubApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventHubApplication.class);
	private static final String EVENT_HUB_NAME = "sample";
	private static final String CONSUMER_GROUP = "$Default";
	private final KafkaTemplate<String, String> kafkaTemplate;

	public EventHubApplication(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(EventHubApplication.class, args);
	}

	@Override
	public void run(String... args) {
		kafkaTemplate.send(EVENT_HUB_NAME, "Hello World");
		LOGGER.info("Message was sent successfully.");
	}
	@KafkaListener(topics = EVENT_HUB_NAME, groupId = CONSUMER_GROUP)
	public void receive(String message) {
		LOGGER.info("New message received: {}", message);
	}

}