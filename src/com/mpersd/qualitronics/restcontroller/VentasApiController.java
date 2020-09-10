package com.mpersd.qualitronics.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.qualitronics.iservice.IVentaService;
import com.mpersd.quialitronics.model.Usuario;

@RestController
@RequestMapping("/api/ventas")
public class VentasApiController {
	@Autowired
	private IVentaService ventaService;
	
	VentasApiController(){}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Venta>> obtenerListado(){
		List<Venta> lista = ventaService.obtenerListado();
		System.out.println("termino de obtener lista"+ lista.size());
		
		if(lista == null) {
			return new ResponseEntity<List<Venta>>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<List<Venta>>(lista,HttpStatus.OK);
	}
}
