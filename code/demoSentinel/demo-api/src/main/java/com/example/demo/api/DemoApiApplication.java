package com.example.demo.api;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author mubi
 * @Date 2019/4/30 9:59 AM
 */
@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan("com.example")
public class DemoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}
}
