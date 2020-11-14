package com.ideas2it.health.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HealthCarePatientModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCarePatientModuleApplication.class, args);
	}

}
