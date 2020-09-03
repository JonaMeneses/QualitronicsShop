package com.mpersd.qualitronics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping(value="dashboard",method = RequestMethod.GET)
	public String dashboard() {
		return "admin/dashboard";
	}

}
