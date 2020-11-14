package com.example.health.vital.signs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerSampleApplication.class, args);
	}
}
