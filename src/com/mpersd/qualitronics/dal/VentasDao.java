package com.mpersd.qualitronics.dal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mpersd.qualitronics.entities.Usuario;
import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.qualitronics.idal.IVentasDao;
import com.mpersd.quialitronics.model.ResultBase;

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

	@Override
	public ResultBase obtenerTotal() {
		ResultBase result = new ResultBase();
		
		Query q = em.createQuery("SELECT COUNT(*) FROM Venta u");
		result.setMensajeRespuesta(Long.toString((Long)q.getSingleResult()));
		return result;
	}

	@Override
	public ResultBase obtenerTotalSemana() {
		
		Calendar c = Calendar.getInstance(); 
		Calendar c2 = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c2.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		
		
		ResultBase result = new ResultBase();
		String consulta ="select COUNT(*) from Venta v where v.dFechaAlta BETWEEN :fechaInicio AND :fechaFin";
		Query q = em.createQuery(consulta);
		q.setParameter("fechaInicio", c.getTime());
		q.setParameter("fechaFin", c2.getTime());
		result.setMensajeRespuesta(Long.toString((Long)q.getSingleResult()));
		return result;
	}

	@Override
	public ResultBase obtenerTotalMes() {
		Calendar c = Calendar.getInstance(); 
		ResultBase result = new ResultBase();
		
		Query q = em.createQuery("SELECT COUNT(*) FROM Venta u where year(u.dFechaAlta) = :añoActual AND month(u.dFechaAlta) = :mesActual");
		q.setParameter("añoActual", c.get(Calendar.YEAR));	
		q.setParameter("mesActual", c.get(Calendar.MONTH));
		System.out.println("MES "+c.get(Calendar.MONTH));
		result.setMensajeRespuesta(Long.toString((Long)q.getSingleResult()));
		return result;	
	}

	@Override
	public ResultBase obtenerTotalAño() {
		ResultBase result = new ResultBase();
		Calendar c = Calendar.getInstance(); 
		Query q = em.createQuery("SELECT COUNT(*) FROM Venta u where year(u.dFechaAlta) = :añoActual");
		q.setParameter("añoActual", c.get(Calendar.YEAR));
		result.setMensajeRespuesta(Long.toString((Long)q.getSingleResult()));
		return result;
	}

	@Override
	public ResultBase obtenerVentasPorIdArticulo(int id) {
		ResultBase result = new ResultBase();
		
		Query q = em.createQuery("SELECT COUNT(*) FROM VentasArticulo u WHERE u.articulo.nId = :id");
		q.setParameter("id", id);
		result.setMensajeRespuesta(Long.toString((Long)q.getSingleResult()));
		return result;
	}



}
