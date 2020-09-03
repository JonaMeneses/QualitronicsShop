package com.mpersd.qualitronics.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mpersd.qualitronics.idal.IUsuarioDao;
import com.mpersd.quialitronics.model.ResultBase;
import com.mpersd.quialitronics.model.Usuario;

@Service
public class UsuarioService implements com.mpersd.qualitronics.iservice.IUsuarioService {
	
	private IUsuarioDao usuarioDao;
	

	public UsuarioService() {
	}

	@Override
	public List<Usuario> obtenerListado() {
		return usuarioDao.obtenerListado();
	}

	@Override
	public List<Usuario> obtenerListadoPorFiltro(String sFiltro) {
		return usuarioDao.obtenerListadoPorFiltro(sFiltro);
	}

	@Override
	public ResultBase insertar(Usuario usuario) {
		ResultBase result = new ResultBase();
		try {
			
			result = usuarioDao.insertar(usuario);
			
		} catch (Exception e) {
			result.setMensajeRespuesta(e.getMessage());
		}
		
		return result;
				
	}

	@Override
	public ResultBase borrar(int id) {
		ResultBase result = new ResultBase();
		try {
			
			result = usuarioDao.borrar(id);
			
		} catch (Exception e) {
			result.setMensajeRespuesta(e.getMessage());
		}
		
		return result;
	}

	@Override
	public ResultBase actualizar(Usuario usuario) {
		ResultBase result = new ResultBase();
		try {
			
			result = usuarioDao.actualizar(usuario);
			
		} catch (Exception e) {
			result.setMensajeRespuesta(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Usuario obtenerPorId(int id) {
		return usuarioDao.obtenerPorId(id);
	}

}
