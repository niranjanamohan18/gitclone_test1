package com.example.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloworldController {
	
	
	//HTTP Get Mapping
	//https://localhost:8080/hello-world
	@GetMapping("/hello-world")
	public String helloWorld() {
		
		return "Hello world!";
	}

}
