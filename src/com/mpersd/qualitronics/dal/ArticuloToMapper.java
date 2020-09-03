package com.mpersd.qualitronics.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mpersd.quialitronics.model.Articulo;

public class ArticuloToMapper  implements RowMapper<Articulo>{

	public ArticuloToMapper() {
		// TODO Auto-generated constructor stub
	}

	public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Articulo(rs.getInt("nId")
					,rs.getString("sNnombre")
					,rs.getString("sDescripcion")
					,rs.getString("sCaracteristicas")
					,rs.getString("sMarca")
					,rs.getInt("nAño")
					,rs.getDouble("nPrecio")
					,rs.getString("sImgURL1")
					,rs.getString("sImgURL2")
					,rs.getString("sTags")
					,rs.getInt("nIdCategoria")
					,rs.getDate("dFechaAlta")
					,rs.getBoolean("bActivo"));
	}
}
