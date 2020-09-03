package com.mpersd.qualitronics.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mpersd.qualitronics.iservice.IUsuarioService;
import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.Usuario;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "catalogoUsuarios/index";
	}
	
	@RequestMapping(path = "altaUsuario", method=RequestMethod.GET)
	public String altaView(ModelMap modelo) {
		modelo.addAttribute("usuario", new Usuario());
		
		return "catalogoUsuarios/altaUsuarios";
	}
	
	@RequestMapping(path = "detalleUsuario", method=RequestMethod.GET)
	public String detalleView(ModelMap modelo,@RequestParam("nId")int nId)
	{
		modelo.addAttribute("nId", nId);
		modelo.addAttribute("detalle", 1);
		return "catalogoUsuarios/altaUsuarios";
	}
	
	@RequestMapping(path = "actualizarUsuario", method=RequestMethod.GET)
	public String actualizarView(ModelMap modelo,@RequestParam("nId")int nId)
	{
		modelo.addAttribute("usuario", usuarioService.obtenerPorId(nId));
		modelo.addAttribute("nId", nId);
		return "catalogoUsuarios/altaUsuarios";
	}
	
	@RequestMapping(path="insertar",method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute("usuario") Usuario usuario,BindingResult result) {
		
		if(result.hasErrors()) {
			return "catalogoUsuarios/altaUsuarios";
		}
		usuarioService.insertar(usuario);
		
		return "redirect:/usuarios/?done";
	}
	
	
	@RequestMapping(path="actualizar",method=RequestMethod.POST)
	public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuario,BindingResult result) {
		if(result.hasErrors()) {
			return "catalogoUsuarios/altaUsuarios";
		}
		System.out.println("entro a controlador");
		usuarioService.actualizar(usuario);
		return "redirect:/usuarios/?done";
	}
	
	
}
