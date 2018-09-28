package com.dexter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Value("${my.custom.message}")
	public String customMessage;
	
	@Value("${OS:NOT_FOUND}")
	public String os;
	
	@PostConstruct
	public void init() {
		System.out.println("MyService is ready.....");
		System.out.println(customMessage);
		System.out.println(os);
	}
	
	public String getMessage(String param) {
		return "Hello "+param;
	}
	
	
}
