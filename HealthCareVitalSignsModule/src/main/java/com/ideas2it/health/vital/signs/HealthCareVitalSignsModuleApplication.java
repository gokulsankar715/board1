package com.ideas2it.health.vital.signs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class HealthCareVitalSignsModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareVitalSignsModuleApplication.class, args);
	}

}
