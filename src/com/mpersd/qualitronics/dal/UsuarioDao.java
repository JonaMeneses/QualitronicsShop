package com.mpersd.qualitronics.dal;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mpersd.qualitronics.idal.IUsuarioDao;
import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.ResultBase;
import com.mpersd.quialitronics.model.Usuario;

@Repository 
public class UsuarioDao implements IUsuarioDao {

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
		String sql = "SELECT t1.nId,t1.sEmail,t1.sContraseña,t1.sNombre,t1.sPaterno,t1.sMaterno,t1.nEdad,t2.nId as nIdRol,t2.sNombre as sNombreRol,t1.dFechaAlta,t1.bActivo FROM usuarios t1 inner join roles_usuarios t3 on t3.nIdUsuario = t1.nId inner join roles t2 on t2.nId = t3.nIdRol where bActivo = 1";
		System.out.println(plantilla.query(sql, new UsuarioToMapper()));
		return plantilla.query(sql, new UsuarioToMapper());
	}

	@Override
	public List<Usuario> obtenerListadoPorFiltro(String sFiltro) {
		String sql = "SELECT *  FROM Usuarios WHERE bActivo = 1 and (sNombre like '%"+sFiltro+"%' or sEmail like '%"+sFiltro+"%')";
		System.out.println(plantilla.query(sql, new UsuarioToMapper()));
		return plantilla.query(sql, new UsuarioToMapper());
	}

	@Override
	public ResultBase insertar(Usuario usuario) {
ResultBase result = new ResultBase();
		
		String SQL = "{call SP_CREAR_USUARIO(?,?,?,?,?,?,?,?)}";
		
		plantilla.update(SQL,usuario.getsEmail(), usuario.getsContraseña()
						,usuario.getsNombre(), usuario.getsPaterno()
						,usuario.getsMaterno(), usuario.getnEdad()
						,usuario.getnIdRol(), usuario.getbActivo());
		
		return result;
	}

	@Override
	public ResultBase borrar(int id) {
		ResultBase result = new ResultBase();
		
		String sql = "UPDATE usuarios SET bActivo = ? WHERE nId= ?";
		plantilla.update(sql,0,id);
		
		return result;
	}

	@Override
	public ResultBase actualizar(Usuario usuario) {
		ResultBase result = new ResultBase();
		System.out.println("id usuario "+usuario.getnId());
		String SQL = "UPDATE usuarios SET sEmail = ?," + 
				"sContraseña = ?," + 
				"sNombre = ?," + 
				"sPaterno = ?," + 
				"sMaterno = ?," + 
				"bActivo = ?," + 
				"nEdad = ? WHERE nId = ?";

		plantilla.update(SQL,usuario.getsEmail(), usuario.getsContraseña()
						,usuario.getsNombre(), usuario.getsPaterno()
						,usuario.getsMaterno()
						,usuario.getbActivo(),usuario.getnEdad(),usuario.getnId());
		
		String SQL2 = "UPDATE roles_usuarios SET nIdRol = ? where nIdUsuario = ?";

		plantilla.update(SQL2,usuario.getnIdRol(), usuario.getnId());
				
		return result;
	}

	@Override
	public Usuario obtenerPorId(int id) {

		String SQL = "SELECT t1.nId,t1.sEmail,t1.sContraseña,t1.sNombre,t1.sPaterno,t1.sMaterno,t1.nEdad,t2.nId as nIdRol,t2.sNombre as sNombreRol,t1.dFechaAlta,t1.bActivo FROM usuarios t1 inner join roles_usuarios t3 on t3.nIdUsuario = t1.nId inner join roles t2 on t2.nId = t3.nIdRol where t1.nId = ?";
		try {
			
			return plantilla.queryForObject(SQL, new UsuarioToMapper(),id);
			
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
