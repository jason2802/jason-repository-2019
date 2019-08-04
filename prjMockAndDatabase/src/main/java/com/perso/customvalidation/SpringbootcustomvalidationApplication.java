package com.perso.customvalidation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.perso.customvalidation.domain.User;
import com.perso.customvalidation.repository.UserRepository;

@SpringBootApplication
public class SpringbootcustomvalidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcustomvalidationApplication.class, args);
	}
	
	@Bean
	    public CommandLineRunner run(UserRepository userRepository) throws Exception {
	        return (String[] args) -> {
	            User user1 = new User("Bob", "bob@domain.com");
	            User user2 = new User("Jenny", "jenny@domain.com");
	            userRepository.save(user1);
	            userRepository.save(user2);
	            userRepository.findAll().forEach(System.out::println);
	        };
	    }

}
