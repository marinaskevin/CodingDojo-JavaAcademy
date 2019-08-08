package com.marinaskevin.stringpages;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringpagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringpagesApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello client! How are you doing?";
	}

	@RequestMapping("/random")
	public String random() {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("Spring Boot is great! So easy to just respond with strings.");
		messages.add("Spring Boot is kicking!");
		messages.add("Spring into action with Spring Boot.");
		messages.add("Get your morning started with Spring Boot!");
		messages.add("Add a sprinkle of Spring Boot into your Java!");
		messages.add("Got Spring Boot?");
		Random random = new Random();
		int index = random.nextInt(messages.size());
		String message = messages.get(index);
		return message;
	}
}
