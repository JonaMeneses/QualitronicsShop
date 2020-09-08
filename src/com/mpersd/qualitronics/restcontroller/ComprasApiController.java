package com.mpersd.qualitronics.restcontroller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mpersd.qualitronics.iservice.IArticuloService;
import com.mpersd.qualitronics.iservice.ICompraService;
import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.Compra;
import com.mpersd.quialitronics.model.ResultBase;
import com.mpersd.quialitronics.model.Usuario;

@RestController
@RequestMapping("api/compras")
@SessionAttributes("compra")
public class ComprasApiController {
	
	@Autowired
	private IArticuloService articuloService;
	
	@Autowired
	private ICompraService compraService;
	
	public ComprasApiController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = "/agregarArticuloCarrito", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> carrito(HttpSession httpSession,@RequestParam("nId")int id,@RequestParam("nCantidad")int nCantidad) {
		ResultBase result = new ResultBase();
		try {
			
			Articulo art =new Articulo(); 
			art = articuloService.obtenerPorId(id);
			art.setnCantidad(nCantidad);
			 
			 Compra compra = (Compra)httpSession.getAttribute("compra");
			 
			 if(compra == null) {
				 compra =  new Compra();
			 }
			 			 
			 for (Articulo articulo : compra.getArticulos()) {
				if(articulo.getnId() == art.getnId()) {
					 art.setnCantidad(art.getnCantidad() + articulo.getnCantidad());
					 compra.getArticulos().set(compra.getArticulos().indexOf(articulo), art);
					 
					 compra.getTotal();
					httpSession.setAttribute("compra", compra);
					return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
				}
			}
			 
			 compra.setArticulo(art);
			 
			 compra.getTotal();
			httpSession.setAttribute("compra", compra);
			
			
			
		} catch (Exception e) {
			result.setMensajeRespuesta(e.getMessage());
		}
		
		return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/obtenerCarrito",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Compra> obtenerCarrito(HttpSession session) {
		ResultBase result = new ResultBase();
		Usuario usr = new Usuario();
		Compra compra =  new Compra(usr,new ArrayList<Articulo>(),0.0);
		
		 if (session.isNew()) {
	            System.out.println("New session: " + session.getId());
	            // TODO: write all session data here?
	            session.setAttribute("compra", compra);
	        } else {
	            // TODO: read all session data here?
	        	 System.out.println("Reused session: " + session.getId() + " Parm is set to: "
	                    + session.getAttribute("compra"));
	        }
		
		try {
			compra = (Compra)session.getAttribute("compra");
			
		} catch (Exception e) {
			result.setMensajeRespuesta(e.getMessage());
		}
		
		return new ResponseEntity<Compra>(compra,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/eliminarArticuloCarrito",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> eliminarArticuloCarrito(HttpSession httpSession,@RequestParam("nId")int nId) {
		ResultBase result = new ResultBase();

			 
			 Compra compra = (Compra)httpSession.getAttribute("compra");
			 
			 if(compra != null) {
				 compra.deleteArticulo(nId);
			 }
			 			
			httpSession.setAttribute("compra", compra);
			
		
		return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/realizarCompra/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultBase> realizarCompra(HttpSession httpSession,@RequestParam("email") String email) {
		ResultBase result = new ResultBase();
	
			Usuario usr = new Usuario(0,email,"","","","",0,0,"",null,true);
			usr.setsEmail(email);
			Compra compra = (Compra)httpSession.getAttribute("compra");
			System.out.println("id usuario = "+email);
			compra.setUsuario(usr);
			
			 if(compra == null) {
				 return new ResponseEntity<ResultBase>(HttpStatus.NOT_ACCEPTABLE);
			 }
			 compraService.realizarCompra(compra);
			 
			result.setMensajeRespuesta("ocurrio un error");
		
		return new ResponseEntity<ResultBase>(result,HttpStatus.OK);
		
	}
	
}
