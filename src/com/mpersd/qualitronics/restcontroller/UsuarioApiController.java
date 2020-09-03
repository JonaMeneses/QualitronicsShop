package com.mpersd.qualitronics.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.qualitronics.iservice.IUsuarioService;
import com.mpersd.quialitronics.model.ResultBase;
import com.mpersd.quialitronics.model.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioApiController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> obtenerListado(){
		List<Usuario> lista = usuarioService.obtenerListado();
		
		if(lista == null) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<List<Usuario>>(lista,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/{nId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> obtenerPorId(@PathVariable("nId") int nId ){
		Usuario usuario = usuarioService.obtenerPorId(nId);
		
		if(usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> insertar(@RequestBody Usuario usuario){
		ResultBase result =new ResultBase();
		result  = usuarioService.insertar(usuario);
		
		if(result.getMensajeRespuesta() != "OK") {
			return new ResponseEntity<ResultBase>(result,HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> actualizar(@RequestBody Usuario usuario){
		ResultBase result =new ResultBase();
		result  = usuarioService.insertar(usuario);
		
		if(result.getMensajeRespuesta() != "OK") {
			return new ResponseEntity<ResultBase>(result,HttpStatus.NOT_FOUND);
		}		 
		 return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{nId}")
	public ResponseEntity<ResultBase> borrarDelete(@PathVariable("nId")int nId){
		ResultBase result =new ResultBase();
		result  = usuarioService.borrar(nId);
		
		if(result.getMensajeRespuesta() != "OK")
		{
			return new ResponseEntity<ResultBase>(result,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
	}
	
	
	
}
