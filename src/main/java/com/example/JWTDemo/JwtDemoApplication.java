package com.example.JWTDemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.JWTDemo.entity.User;
import com.example.JWTDemo.repository.UserRepository;

@SpringBootApplication
public class JwtDemoApplication {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101,"Shravan", "pwd","shravansanidhya@gmail.com"),
				new User(102,"Ashish", "pwd1","shravansanidhya@gmail.com"),
				new User(103,"Mohan", "pwd2","shravansanidhya@gmail.com"),
				new User(104,"Rohit", "pwd3","shravansanidhya@gmail.com")
				).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

}
