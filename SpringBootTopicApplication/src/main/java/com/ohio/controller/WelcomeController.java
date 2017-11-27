package com.ohio.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping(value="/welcome")
	public String welcome(){
		return "Why is it working now????!";
	}
	
	@RequestMapping(value="/names")
	public List<String> getNames(){
		return Arrays.asList("Hagos","Belay","Mehari","Berhe","Berhane");
	}
}
