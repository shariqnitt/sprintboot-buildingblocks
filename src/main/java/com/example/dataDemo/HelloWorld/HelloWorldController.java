package com.example.dataDemo.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World !!";
	}
	
	@GetMapping("/hello-world-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Md", "Shariq", "Bangalore");
		
	}
	
}
