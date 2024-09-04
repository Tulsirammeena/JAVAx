package com.stockExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.stockExchange.controller.Demo;
import com.stockExchange.repository.UserRepo;

@SpringBootApplication
@EnableJpaRepositories("com.stockExchange.repository")
public class ExchangeApplication {
	
//	@Autowired
//	private UserRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void init() {
//		repo.saveAll(Demo.users);
//	}
	
//	@Bean
//	public Demo demo() {
//		
//	}

}
