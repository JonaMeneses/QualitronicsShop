package com.mpersd.qualitronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mpersd.qualitronics.iservice.IArticuloService;
import com.mpersd.qualitronics.iservice.ICompraService;
import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.Compra;
import com.mpersd.quialitronics.model.ResultBase;

@Controller
@RequestMapping("/compras")
public class ComprasController {
	@Autowired
	private ICompraService compraService;	
	@Autowired
	private IArticuloService articuloService;

	public ComprasController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("carrito")
	public String carrito() {
			
		return "compras/carrito"; 
	}	
	
	@GetMapping("checkout")
	public String checkout() {
		
		return "compras/checkout"; 
	}	
	
	@GetMapping(path = "/agregarArticuloCarrito", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> carrito(@RequestParam("nId")int id) {
		ResultBase result = new ResultBase();
		
			Articulo art =new Articulo(); 
			art = articuloService.obtenerPorId(id);
			art.setnPrecio(art.getnPrecio() - (art.getnPrecio()*art.getnPromocion()));
			Compra compra = new Compra();
			System.out.println("nombre de articulo: "+art.getsNombre());
			System.out.println("precio con descuento: "+art.getnPrecio());
			compra.setArticulo(art);	
	
		
		return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
		
	}
}
