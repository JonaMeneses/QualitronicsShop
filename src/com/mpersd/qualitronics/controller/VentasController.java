package com.mpersd.qualitronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.qualitronics.iservice.IArticuloService;
import com.mpersd.qualitronics.iservice.ICompraService;
import com.mpersd.qualitronics.iservice.IVentaService;
import com.mpersd.quialitronics.model.Articulo;

@Controller
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	private IVentaService ventaService;	
	
	@Autowired
	public VentasController() {}
	
	@GetMapping
	public String listado() {
		return "ventas/index";
	}
	
	@GetMapping("detalle")
	public String DetalleView(ModelMap modelo,@RequestParam("nId")int nId) {
		Venta venta = ventaService.detalle(nId);
		System.out.println("id="+venta.getNId());
		modelo.addAttribute("venta", venta);	
		return "ventas/detalle";
	}
	
	
}
