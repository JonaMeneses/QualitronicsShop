package com.mpersd.qualitronics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mpersd.qualitronics.iservice.IArticuloService;
import com.mpersd.quialitronics.model.Articulo;


@Controller
@RequestMapping("/articulos")
public class ArticuloController {

	@Autowired
	private IArticuloService articuloService;	

	public ArticuloController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(path="detalleView",method=RequestMethod.GET)
	public String DetalleView(@RequestParam("nId")int id,ModelMap modelo){
		Articulo articulo = articuloService.obtenerPorId(id);
		modelo.addAttribute("articulo", articulo);
		return "catalogoArticulos/detalleArticulo";
		}
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelo) {
		List<Articulo> lista = articuloService.getArticulos();
		modelo.addAttribute("articulos",lista);
		return "catalogoArticulos/index";
	}
	
	@RequestMapping(value="listado",method=RequestMethod.GET)
	public String listado(ModelMap modelo) {
		List<Articulo> lista = articuloService.getArticulos();
		modelo.addAttribute("articulos",lista);
		return "catalogoArticulos/listado";
	}
	
	@RequestMapping(value="listadoPorFiltro",method=RequestMethod.GET)
	public String listado(ModelMap modelo,@RequestParam("sFiltro") String sFiltro) {
		List<Articulo> lista = articuloService.getArticulosPorFiltro(sFiltro);
		modelo.addAttribute("articulos",lista);
		return "catalogoArticulos/index";
	}
	
	@RequestMapping(path="nuevo",method=RequestMethod.GET)
	public String insertarView(ModelMap modelo) {
		System.out.println("nuevo Articulo");
		modelo.addAttribute("articulo", new Articulo());
		return "catalogoArticulos/altaArticulos";
	}
	
	@RequestMapping(path="nuevo",method=RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute("articulo") Articulo articulo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "catalogoArticulos/altaArticulos";
		}
		articuloService.insertar(articulo);
		
		return "redirect:/articulos/listado?done";
	}
	
	@RequestMapping(path="actualiza",method=RequestMethod.GET)
	public String actualizarView(ModelMap modelo,@RequestParam("nId") int nId) {
		Articulo articulo = articuloService.obtenerPorId(nId);
		modelo.addAttribute("articulo", articulo);
		return "catalogoArticulos/altaArticulos";
	}
	
	@RequestMapping(path="actualiza",method=RequestMethod.POST)
	public String actualizar(@Valid @ModelAttribute("articulo") Articulo articulo,BindingResult result) {
		if(result.hasErrors()) {
			return "catalogoArticulos/altaArticulos";
		}
		articuloService.actualizar(articulo);
		return "redirect:/articulos/listado?done";
	}
	
	@RequestMapping(path="eliminar",method=RequestMethod.GET)
	public String borrar(@RequestParam("nId") int id) {
		articuloService.borrar(id);
		return "redirect:/articulos/listado?delete";
	}
	
	@RequestMapping(path="obtenerporid",method=RequestMethod.GET)
	public String obtenerPorId(ModelMap modelo,@RequestParam("nId")int id)
	{
		Articulo articulo = articuloService.obtenerPorId(id);
		modelo.addAttribute("articulo", articulo);
		modelo.addAttribute("detalle", 1);
		return "catalogoArticulos/altaArticulos";
	}

}
