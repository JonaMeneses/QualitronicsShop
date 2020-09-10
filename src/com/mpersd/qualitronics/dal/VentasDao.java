package com.mpersd.qualitronics.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mpersd.qualitronics.entities.Usuario;
import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.qualitronics.idal.IVentasDao;

@Repository
public class VentasDao implements IVentasDao {

	@PersistenceContext(unitName = "springPU")
	EntityManager em;
	
	@Override
	public Venta detalle(int nId) {
		Venta venta = new Venta();
		venta = em.find(venta.getClass(), nId);
		System.out.println("id venta "+venta.getNTotal());
		System.out.println("tamaño lista "+ venta.getVentasArticulos().size());
		System.out.println("id usuario "+ venta.getUsuario().getNId());
		return venta;
	}

	@Override
	public List<Venta> obtenerListado() {
		Query q = em.createQuery("SELECT u FROM Venta u");
		return q.getResultList();
	}

}
