package com.example.elastic.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.elastic.demo.Controller.ElasticSwaggerController;

@SpringBootTest
class ElasticServerSampleApplicationTests {

	@Test
	public void getAds() {
		ElasticSwaggerController es = new ElasticSwaggerController();
		String s = es.getAd("1");
		assertEquals("Gokul", s);
	}

}
