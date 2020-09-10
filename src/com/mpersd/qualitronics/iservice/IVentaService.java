package com.mpersd.qualitronics.iservice;

import java.util.List;

import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.quialitronics.model.ResultBase;

public interface IVentaService {
	public Venta detalle(int nId);
	public List<Venta> obtenerListado();
	public ResultBase obtenerTotal();
	public ResultBase obtenerTotalSemana();
	public ResultBase obtenerTotalMes();
	public ResultBase obtenerTotalAño();
	public ResultBase obtenerVentasPorIdArticulo(int id);
}
