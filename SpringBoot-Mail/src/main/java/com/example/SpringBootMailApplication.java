package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.MyEmailService;

@SpringBootApplication
public class SpringBootMailApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootMailApplication.class, args);
		MyEmailService bean = run.getBean(MyEmailService.class);
		//bean.sendSimpleMessage("vinaykumar.vvk1998@gmail.com", "Test", "SpringBoot");
		bean.sendEmailWithAttachment();
		
	}

}
