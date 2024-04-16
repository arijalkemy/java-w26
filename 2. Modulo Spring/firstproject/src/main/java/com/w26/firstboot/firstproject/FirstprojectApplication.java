package com.w26.firstboot.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("controllers")
public class FirstprojectApplication {

	public static void main(String[] args) {
		System.out.println("Holy");
		SpringApplication.run(FirstprojectApplication.class, args);
	}

}
