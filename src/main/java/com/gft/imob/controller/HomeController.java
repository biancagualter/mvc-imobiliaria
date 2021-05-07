package com.gft.imob.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String Start(){

		return "redirect:/login";
	}
	
	@RequestMapping("/home")
	public String Home(){

		return "Home";
	}
	
	@RequestMapping("/homepage")
	public String Homepage(){

		return "Homepage";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String Login() {
		return "Login";
	}
}