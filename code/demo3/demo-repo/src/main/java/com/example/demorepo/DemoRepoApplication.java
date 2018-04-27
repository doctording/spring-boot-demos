package com.example.demorepo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demorepo.repository")
public class DemoRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRepoApplication.class, args);
	}
}
