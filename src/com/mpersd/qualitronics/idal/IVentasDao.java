package com.mpersd.qualitronics.idal;

import java.util.List;

import com.mpersd.qualitronics.entities.Venta;

public interface IVentasDao {
	public Venta detalle(int nId);
	public List<Venta> obtenerListado();
}
