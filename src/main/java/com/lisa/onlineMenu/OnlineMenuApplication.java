package com.lisa.onlineMenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;

@ComponentScan(basePackages = "com.lisa.onlineMenu")
@RestController
@SpringBootApplication
public class OnlineMenuApplication {

	@RequestMapping("/hello")
	public String index(){
		return "Hello World， Spring boot is good";
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineMenuApplication.class, args);
	}


	@Bean
	MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		////文件最大
		factory.setMaxFileSize(DataSize.parse("5MB"));
		factory.setLocation("D:\\Menu-Pictures");
		return factory.createMultipartConfig();
	}


}
