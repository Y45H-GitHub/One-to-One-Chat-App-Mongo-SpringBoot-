package com.yash.WSChatApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.yash")
@EnableMongoRepositories(basePackages = "com.yash.repo")
public class WsChatAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsChatAppApplication.class, args);
	}

}
