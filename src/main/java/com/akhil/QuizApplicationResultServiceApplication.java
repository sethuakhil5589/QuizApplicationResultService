package com.akhil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizApplicationResultServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplicationResultServiceApplication.class, args);
	}

}
