package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.GreetingsGenerator;

@Controller
@RequestMapping("api")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET, value = "hello/{id}")
	public @ResponseBody String hello(@PathVariable int id ) {
		
		String greetings = GreetingsGenerator.Greetings(id);
		
		return greetings;
	}

}
