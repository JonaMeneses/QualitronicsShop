package com.mpersd.qualitronics.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.qualitronics.iservice.IArticuloService;
import com.mpersd.quialitronics.model.Articulo;

@RestController
@RequestMapping("/api/articulo")
public class ArticuloApiController {
	
	@Autowired
	private IArticuloService articuloService;

	public ArticuloApiController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Articulo> obtenerArticuloPorId(@PathVariable("id") int id ){
			Articulo articulo = articuloService.obtenerPorId(id);
			System.out.println(articulo);
			

		if(articulo == null) {
			return new ResponseEntity<Articulo>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<Articulo>(articulo,HttpStatus.OK);
	}
	
	@GetMapping(path = "/detalle",produces = MediaType.TEXT_HTML_VALUE)
	public String DetalleView(){
		return "catalogoArticulos/detalleArticulo";
	}
	
	

}
