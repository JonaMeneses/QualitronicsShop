package com.mpersd.qualitronics.idal;

import java.util.List;

import com.mpersd.quialitronics.model.ResultBase;
import com.mpersd.quialitronics.model.Usuario;

public interface IUsuarioDao {
	public List<Usuario> obtenerListado();
	public List<Usuario> obtenerListadoPorFiltro(String sFiltro);
	ResultBase insertar(Usuario usuario);
	ResultBase borrar(int id);
	ResultBase actualizar(Usuario usuario);
	Usuario obtenerPorId(int id);
}
