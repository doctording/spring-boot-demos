package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author mubi
 * @Date 2018/7/20 下午3:09
 */
@SpringBootApplication
@MapperScan("com.example.demo.repository")
@EnableScheduling
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * 生成war: gradle build,或者利用idea gradle工具build
	 * 例如：demo2-0.0.1-SNAPSHOT.war拷贝到tomcat/webapps目录下
	 * 然后启动tomcat，访问：http://localhost:8080/demo2-0.0.1-SNAPSHOT/test 即可
	  */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}

}