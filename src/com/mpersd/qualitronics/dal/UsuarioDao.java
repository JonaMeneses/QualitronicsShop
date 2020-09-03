package com.mpersd.qualitronics.dal;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.ResultBase;
import com.mpersd.quialitronics.model.Usuario;

public class UsuarioDao implements com.mpersd.qualitronics.idal.IUsuarioDao {

	private JdbcTemplate plantilla;	
	
	
	public UsuarioDao() {
		// TODO Auto-generated constructor stub
	}

	@Autowired 
	@Qualifier("ds-local")
	public void setDataSource(DataSource ds) {
		this.plantilla = new JdbcTemplate(ds);
	}
	
	@Override
	public List<Usuario> obtenerListado() {
		String sql = "SELECT *  FROM usuarios";
		System.out.println(plantilla.query(sql, new UsuarioToMapper()));
		return plantilla.query(sql, new UsuarioToMapper());
	}

	@Override
	public List<Usuario> obtenerListadoPorFiltro(String sFiltro) {
		String sql = "SELECT *  FROM Usuarios WHERE bActivo = 1 and (sNnombre like '%"+sFiltro+"%' or sEmail like '%"+sFiltro+"%')";
		System.out.println(plantilla.query(sql, new UsuarioToMapper()));
		return plantilla.query(sql, new UsuarioToMapper());
	}

	@Override
	public ResultBase insertar(Usuario usuario) {
ResultBase result = new ResultBase();
		
		String SQL = "insert into articulos(`sEmail`," + 
				"`sContraseña`," + 
				"`sNombre`," + 
				"`sPaterno`," + 
				"`sMaterno`," + 
				"`nEdad`) values (?,?,?,?,?,?)";

		plantilla.update(SQL,usuario.getsEmail(), usuario.getsContraseña()
						,usuario.getsNombre(), usuario.getPaterno()
						,usuario.getsMaterno(), usuario.getnEdad());
	
		
		return result;
	}

	@Override
	public ResultBase borrar(int id) {
		ResultBase result = new ResultBase();
		
		String sql = "UPDATE FROM usuarios SET bAtivo = 0 WHERE nId= ?";
		plantilla.update(sql,id);
		
		return result;
	}

	@Override
	public ResultBase actualizar(Usuario usuario) {
		ResultBase result = new ResultBase();
		
		String SQL = "UPDATE usuarios SET sEmail = ?," + 
				"sContraseña = ?," + 
				"sNombre = ?," + 
				"sPaterno = ?," + 
				"sMaterno = ?," + 
				"nEdad = ? WHERE nId = ?";

		plantilla.update(SQL,usuario.getsEmail(), usuario.getsContraseña()
						,usuario.getsNombre(), usuario.getPaterno()
						,usuario.getsMaterno(), usuario.getnEdad(), usuario.getnId());
		
		return result;
	}

	@Override
	public Usuario obtenerPorId(int id) {

		String SQL = "SELECT * FROM articulos where nId = ?";
		try {
			
			return plantilla.queryForObject(SQL, new UsuarioToMapper(),id);
			
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
