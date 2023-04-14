package com.cepapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients //habilita o Feign na aplicação para requisição api externa
public class ApiCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCepApplication.class, args);
	}

}
