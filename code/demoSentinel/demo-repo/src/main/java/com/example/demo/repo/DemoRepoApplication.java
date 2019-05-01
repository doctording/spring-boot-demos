package com.example.demo.repo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author mubi
 * @Date 2019/4/30 10:04 AM
 */
@SpringBootApplication
@MapperScan("com.example.demo.repo.mapper")
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class DemoRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRepoApplication.class, args);
	}
}
