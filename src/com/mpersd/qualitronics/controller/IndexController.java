package com.mpersd.qualitronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mpersd.qualitronics.iservice.IArticuloService;
import com.mpersd.quialitronics.model.Articulo;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private IArticuloService articuloService;	
	
	public IndexController() {
		System.out.println("entro a indexcontroller");
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelo) {
		List<Articulo> lista = articuloService.getArticulos();
		modelo.addAttribute("articulos",lista);
		return "index";
	}
	
	@RequestMapping(value="listado",method=RequestMethod.GET)
	public String listado(ModelMap modelo) {
		List<Articulo> lista = articuloService.getArticulos();
		modelo.addAttribute("articulos",lista);
		return "catalogoArticulos/listado";
	}
	
	
}
