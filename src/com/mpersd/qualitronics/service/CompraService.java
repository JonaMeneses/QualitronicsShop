package com.mpersd.qualitronics.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpersd.qualitronics.entities.Articulo;
import com.mpersd.qualitronics.idal.ICompraDao;
import com.mpersd.qualitronics.iservice.ICompraService;
import com.mpersd.quialitronics.model.Compra;
import com.mpersd.quialitronics.model.ResultBase;

@Service
public class CompraService implements ICompraService {
	
	@Autowired
	private ICompraDao compraDao;

	public CompraService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultBase agregarArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultBase eliminarArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override @Transactional	
	public ResultBase realizarCompra(Compra compra) {
		return compraDao.realizarCompra(compra);
		
		 
	}

}
