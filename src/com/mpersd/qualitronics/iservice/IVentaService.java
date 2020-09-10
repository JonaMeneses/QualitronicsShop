package com.mpersd.qualitronics.iservice;

import java.util.List;

import com.mpersd.qualitronics.entities.Venta;

public interface IVentaService {
	public Venta detalle(int nId);
	public List<Venta> obtenerListado();
}
