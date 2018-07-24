package com.example.demo;

import com.example.demo.service.impl.KafkaSender;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author mubi
 * @Date 2018/7/20 下午3:09
 */
@SpringBootApplication
@MapperScan("com.example.demo.repository")
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private KafkaSender kafkaSender;

	/**
	 * 然后每隔1分钟执行一次
 	 */
	@Scheduled(fixedRate = 1000 * 60)
	public void testKafka() throws Exception {
		kafkaSender.sendTest();
	}

}