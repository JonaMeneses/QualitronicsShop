package com.mpersd.qualitronics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class loginController {

	public loginController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		System.out.println("entro a index Login");
		return "login";
	}

}
