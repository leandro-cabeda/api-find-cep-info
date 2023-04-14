package com.cepapi;

import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ApiCepApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCucumber {

}
