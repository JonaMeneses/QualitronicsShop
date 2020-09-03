package com.mpersd.qualitronics.iservice;

import java.util.List;

import com.mpersd.quialitronics.model.ResultBase;
import com.mpersd.quialitronics.model.Usuario;

public interface IUsuarioService {
	public List<Usuario> obtenerListado();
	public List<Usuario> obtenerListadoPorFiltro(String sFiltro);
	ResultBase insertar(Usuario usuario);
	ResultBase borrar(int id);
	ResultBase actualizar(Usuario usuario);
	Usuario obtenerPorId(int id);
}
