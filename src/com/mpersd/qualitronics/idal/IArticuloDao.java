package com.mpersd.qualitronics.idal;

import java.util.List;

import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.ResultBase;

public interface IArticuloDao {
	
	public List<Articulo> getArticulos();
	ResultBase insertar(Articulo articulo);
	ResultBase borrar(int id);
	ResultBase actualizar(Articulo articulo);
	Articulo obtenerPorId(int id);
	public List<Articulo> getArticulosPorFiltro(String sFiltro);
	public List<Articulo> getArticulosPorCategoria(String sFiltro);

}
