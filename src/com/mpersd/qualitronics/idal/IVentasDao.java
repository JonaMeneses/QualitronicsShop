package com.mpersd.qualitronics.idal;

import java.util.List;

import com.mpersd.qualitronics.entities.Venta;
import com.mpersd.quialitronics.model.ResultBase;

public interface IVentasDao {
	public Venta detalle(int nId);
	public List<Venta> obtenerListado();
	public ResultBase obtenerTotal();
	public ResultBase obtenerTotalSemana();
	public ResultBase obtenerTotalMes();
	public ResultBase obtenerTotalA�o();
	public ResultBase obtenerVentasPorIdArticulo(int id);
}
