package com.ideas2it.health.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
@EnableFeignClients
@RefreshScope
@EnableJpaAuditing
public class HealthCareUserModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareUserModuleApplication.class, args);
	}
}
