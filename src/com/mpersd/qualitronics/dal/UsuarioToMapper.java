package com.mpersd.qualitronics.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.Usuario;

public class UsuarioToMapper implements RowMapper<Usuario> {
	
	public UsuarioToMapper() {
		// TODO Auto-generated constructor stub
	}

	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Usuario(rs.getInt("nId")
				,rs.getString("sEmail")
				,rs.getString("sContraseña")
				,rs.getString("sNombre")
				,rs.getString("sPaterno")
				,rs.getString("sMaterno")
				,rs.getInt("nEdad")
				,rs.getDate("dFechaAlta")
				,rs.getBoolean("bActivo"));
	}
}
