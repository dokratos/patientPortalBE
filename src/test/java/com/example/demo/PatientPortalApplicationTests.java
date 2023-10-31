package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PatientPortalApplicationTests {

	@Value("${server.port}")
	private int port;

	@Autowired
	RestTemplate restTemplate;


	@Test
	void contextLoads() {
	}

}
