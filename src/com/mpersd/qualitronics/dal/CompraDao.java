package com.mpersd.qualitronics.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mpersd.qualitronics.entities.Articulo;
import com.mpersd.qualitronics.entities.Usuario;
import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.qualitronics.entities.VentasArticulo;
import com.mpersd.qualitronics.idal.ICompraDao;
import com.mpersd.quialitronics.model.Compra;
import com.mpersd.quialitronics.model.ResultBase;

@Repository
public class CompraDao implements ICompraDao {
	
	@PersistenceContext(unitName = "springPU")
	EntityManager em;

	public CompraDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultBase realizarCompra(Compra compra) {
		
		Venta venta = new Venta();
		Query q = em.createQuery("SELECT u FROM Usuario u where u.sEmail = '"+ compra.getUsuario().getsEmail()+"'");
		Usuario usr = (Usuario)q.getSingleResult();
		venta.setNTotal(compra.getnTotal());
		venta.setUsuario(usr);
		List<VentasArticulo> articulos =new ArrayList<VentasArticulo>();
		for (com.mpersd.quialitronics.model.Articulo art : compra.getArticulos()) {
			
			VentasArticulo ventaArt = new VentasArticulo();
			Articulo articulo  = em.find(Articulo.class,art.getnId());
			ventaArt.setArticulo(articulo);
		}
		venta.setVentasArticulos(articulos);
		
		em.persist(venta);
		
		return null;
	}

}
