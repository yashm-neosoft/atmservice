package com.example.atmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class AtmserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AtmserviceApplication.class, args);

	}

}
