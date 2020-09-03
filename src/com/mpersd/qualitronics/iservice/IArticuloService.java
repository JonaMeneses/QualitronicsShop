package com.mpersd.qualitronics.iservice;

import java.util.List;
import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.ResultBase;

public interface IArticuloService {
	public List<Articulo> getArticulos();
	public List<Articulo> getArticulosPorFiltro(String sFiltro);
	public List<Articulo> getArticulosPorCategoria(String sFiltro);
	ResultBase insertar(Articulo articulo);
	ResultBase borrar(int id);
	ResultBase actualizar(Articulo articulo);
	Articulo obtenerPorId(int id);
}
