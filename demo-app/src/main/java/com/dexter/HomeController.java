package com.dexter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Value("${my.custom.environment: default}")
	String environment="";
	
	@Autowired
	private DummyService dummyService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("environment",environment);
		model.addAttribute("serverTime",dummyService.getTime());
		return "profile";
	}
}
