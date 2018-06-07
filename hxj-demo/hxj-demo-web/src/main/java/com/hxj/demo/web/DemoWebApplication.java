package com.hxj.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.hxj")
@SpringBootApplication
public class DemoWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}
}