package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication()
public class MyApplication {
	public static void main(String[] args) {
		System.out.println("main hit");
		SpringApplication.run(MyApplication.class, args);
		System.out.println("main End Point hit");

	}
}
