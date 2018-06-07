package com.hxj.acl.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.hxj.acl.rpc.mapper")
@SpringBootApplication
public class AclRpcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AclRpcApplication.class, args);
	}
}