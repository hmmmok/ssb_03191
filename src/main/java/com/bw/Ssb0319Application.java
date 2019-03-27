package com.bw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.bw.mapper")
@SpringBootApplication
public class Ssb0319Application {

	public static void main(String[] args) {
		SpringApplication.run(Ssb0319Application.class, args);
	}

}
