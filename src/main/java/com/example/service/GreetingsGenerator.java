package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingsGenerator {
	
	public static String Greetings(int id) {
		
		String greetings = "";
		
		switch(id) {
			case 1:
				greetings = "Hi there!";
				break;
			case 2: 
				greetings = "Howdy!";
				break;
			case 3:
				greetings = "Good day!";
				break;
			case 4: 
				greetings = "Greetings!";
				break;
			default:
				greetings = "Hello!?";
		
		}
			
				
		return greetings;
	}

}
