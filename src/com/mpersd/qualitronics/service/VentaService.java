package com.mpersd.qualitronics.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.qualitronics.idal.IVentasDao;
import com.mpersd.qualitronics.iservice.IVentaService;
import com.mpersd.quialitronics.model.ResultBase;

@Service
public class VentaService implements IVentaService {

	@Autowired
	private IVentasDao ventasDao;
	
	@Override
	@Transactional
	public Venta detalle(int nId) {
		Venta venta = ventasDao.detalle(nId);
		return venta;
	}

	@Override
	@Transactional
	public List<Venta> obtenerListado() {
		List<Venta> listado = ventasDao.obtenerListado();
		return listado;
	}

	@Override
	public ResultBase obtenerTotal() {
		
		return ventasDao.obtenerTotal();
	}

	@Override
	public ResultBase obtenerTotalSemana() {
		return ventasDao.obtenerTotalSemana();
	}

	@Override
	public ResultBase obtenerTotalMes() {
		return ventasDao.obtenerTotalMes();
	}

	@Override
	public ResultBase obtenerTotalAño() {
		return ventasDao.obtenerTotalAño();
	}

	@Override
	public ResultBase obtenerVentasPorIdArticulo(int id) {

		return ventasDao.obtenerVentasPorIdArticulo(id);
	}

	

}
