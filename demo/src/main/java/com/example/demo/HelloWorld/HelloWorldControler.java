package com.example.demo.HelloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldControler {
	
	@GetMapping(path="/hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
//		throw new RuntimeException("Sumthing went wrong");
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}
