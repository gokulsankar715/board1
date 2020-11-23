package com.example.elastic.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class ElasticServerSampleApplication implements CommandLineRunner {

	@Value("${healthcare.all.patient.url}")
	private String url;

	public static void main(String[] args) {
		SpringApplication.run(ElasticServerSampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(url);

	}

}
