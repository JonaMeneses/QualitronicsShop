package com.mpersd.qualitronics.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.qualitronics.iservice.IVentaService;
import com.mpersd.quialitronics.model.ResultBase;
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
	
	@GetMapping(value = "total",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> obtenerTotal(){
		ResultBase result = ventaService.obtenerTotal();
		System.out.println(result.getMensajeRespuesta());
		if(result == null) {
			return new ResponseEntity<ResultBase>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	
	@GetMapping(value = "totalSemana",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> obtenerTotalPorSemana(){
		ResultBase result = ventaService.obtenerTotalSemana();
		System.out.println(result.getMensajeRespuesta());
		if(result == null) {
			return new ResponseEntity<ResultBase>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	@GetMapping(value = "totalMes",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> obtenerTotalPorMes(){
		ResultBase result = ventaService.obtenerTotalMes();
		System.out.println(result.getMensajeRespuesta());
		if(result == null) {
			return new ResponseEntity<ResultBase>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	@GetMapping(value = "totalAño",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> obtenerTotalPorAño(){
		ResultBase result = ventaService.obtenerTotalAño();
		System.out.println(result.getMensajeRespuesta());
		if(result == null) {
			return new ResponseEntity<ResultBase>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	
	@GetMapping(value = "/mostrarEstrellas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> mostrarEstrellas(@PathVariable("id") int id){
		ResultBase result = ventaService.obtenerVentasPorIdArticulo(id);

		if(result == null) {
			return new ResponseEntity<ResultBase>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	
	
}
