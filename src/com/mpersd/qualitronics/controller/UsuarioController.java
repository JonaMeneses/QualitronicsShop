package com.mpersd.qualitronics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "usuarios/index";
	}
	
	@RequestMapping(path = "form", method=RequestMethod.GET)
	public String formulario() {
		return "usuarios/form";
	}
}
