package com.example.JWTDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JWTDemo.entity.AuthRequest;
import com.example.JWTDemo.util.JWTUtil;

@RestController
public class HomeController {

	@Autowired
	private JWTUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Security.";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
	try {	
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
	);
	} catch(Exception  e) {
		throw new Exception("invalid username/password");
	}
	   
	     return jwtutil.generateToken(authRequest.getUsername());
	}
	
}
