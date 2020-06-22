package com.cubic.it.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

class Dog{
	String name="tommy";
	String color="white";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}

@RestController
public class HelloCool {
	
	@GetMapping("/ddog")
	public Dog dogaga() {
		return new Dog();
	}

}
