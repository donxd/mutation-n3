package com.teamknowlogy.testapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mangofactory.swagger.plugin.EnableSwagger;

@SpringBootApplication
@EnableSwagger
public class TestApiApp {
	
	public static void main (String [] args) {
		SpringApplication.run(TestApiApp.class, args);
	}
}