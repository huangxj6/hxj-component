package com.hxj.demo.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.hxj.demo.rpc.mapper")
@ComponentScan("com.hxj")
@SpringBootApplication
public class DemoRpcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoRpcApplication.class, args);
	}
}