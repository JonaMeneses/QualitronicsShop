package com.mpersd.qualitronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpersd.qualitronics.idal.IArticuloDao;
import com.mpersd.qualitronics.iservice.IArticuloService;
import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.ResultBase;

@Service
public class ArticuloService implements IArticuloService {
	
	@Autowired
	private IArticuloDao articuloDao;
	
	public ArticuloService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Articulo> getArticulos() {
		return articuloDao.getArticulos();
	}
	
	@Override
	public List<Articulo> getArticulosPorFiltro(String sFiltro) {
		return articuloDao.getArticulosPorFiltro(sFiltro);
	}

	@Override
	public ResultBase insertar(Articulo articulo) {
		ResultBase result = new ResultBase();
		result = articuloDao.insertar(articulo);
		
		//TODO:realizar validacion de tipos
		
		return result;
	}

	@Override
	public ResultBase borrar(int id) {
		ResultBase result = new ResultBase();
		result = articuloDao.borrar(id);
		
		//TODO:realizar validacion de tipos
		
		return result;

	}

	@Override
	public ResultBase actualizar(Articulo articulo) {
		ResultBase result = new ResultBase();
		result = articuloDao.actualizar(articulo);
		
		//TODO:realizar validacion de tipos
		
		return result;
	}

	@Override
	public Articulo obtenerPorId(int id) {
		return articuloDao.obtenerPorId(id);
	}

	
}
