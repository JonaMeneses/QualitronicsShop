package com.mpersd.qualitronics.dal;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mpersd.qualitronics.idal.IArticuloDao;
import com.mpersd.quialitronics.model.Articulo;
import com.mpersd.quialitronics.model.ResultBase;

@Repository
public class ArticuloDao implements IArticuloDao {

	private JdbcTemplate plantilla;
	
	public ArticuloDao() {
		// TODO Auto-generated constructor stub
	}

	@Autowired 
	@Qualifier("ds-local")
	public void setDataSource(DataSource ds) {
		this.plantilla = new JdbcTemplate(ds);
	}
	
	@Override
	public List<Articulo> getArticulos() {
		String sql = "SELECT *  FROM articulos";
		System.out.println(plantilla.query(sql, new ArticuloToMapper()));
		return plantilla.query(sql, new ArticuloToMapper());

	}
	
	@Override
	public List<Articulo> getArticulosPorFiltro(String sFiltro) {
		String sql = "SELECT *  FROM articulos WHERE bActivo = 1 and (sNnombre like '%"+sFiltro+"%' or sTags like '%"+sFiltro+"%')";
		System.out.println(plantilla.query(sql, new ArticuloToMapper()));
		return plantilla.query(sql, new ArticuloToMapper());
	}
	
	@Override
	public List<Articulo> getArticulosPorCategoria(String sFiltro) {
		String sql = "SELECT *  FROM articulos WHERE bActivo = 1 and nIdCategoria = "+sFiltro+"";
		System.out.println(plantilla.query(sql, new ArticuloToMapper()));
		return plantilla.query(sql, new ArticuloToMapper());
	}

	@Override
	public ResultBase insertar(Articulo articulo) {
		ResultBase result = new ResultBase();
		
		String SQL = "insert into articulos(`sNnombre`," + 
				"`sDescripcion`," + 
				"`sCaracteristicas`," + 
				"`sMarca`," + 
				"`nAño`," + 
				"`nPrecio`," + 
				"`sImgURL1`," + 
				"`sImgURL2`," + 
				"`sTags`," + 
				"`nIdCategoria`,`nPromocion`) values (?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(SQL);
		System.out.println(articulo.getsNombre());
		System.out.println(articulo.getsDescripcion());
		System.out.println(articulo.getsCaracteristica());
		System.out.println(articulo.getnPrecio());
		System.out.println(articulo.getnAño());
		System.out.println(articulo.getsMarca());
		System.out.println(articulo.getsImgURL2());
		System.out.println(articulo.getsImgURL1());
		System.out.println(articulo.getsTag());
		System.out.println(articulo.getnIdCategoria());
		plantilla.update(SQL,articulo.getsNombre(),articulo.getsDescripcion(),
						articulo.getsCaracteristica(),articulo.getsMarca(),
						articulo.getnAño(),articulo.getnPrecio(),
						articulo.getsImgURL1(),articulo.getsImgURL2(),
						articulo.getsTag(), articulo.getnIdCategoria(),articulo.getnPromocion());
	
		
		return result;
	}

	@Override
	public ResultBase borrar(int nId) {
		ResultBase result = new ResultBase();
		
		String sql = "DELETE FROM articulos WHERE nId= ?";
		plantilla.update(sql,nId);
		
		return result;
	}

	@Override
	public ResultBase actualizar(Articulo articulo) {
		ResultBase result = new ResultBase();
		
		String SQL = "UPDATE articulos SET sNnombre = ?," + 
				"sDescripcion = ?," + 
				"sCaracteristicas = ?," + 
				"sMarca = ?," + 
				"nAño = ?," + 
				"nPrecio = ?," + 
				"sImgURL1 = ?," + 
				"sImgURL2 = ?," + 
				"sTags = ?," + 
				"nIdCategoria = ?, nPromocion = ? WHERE nId = ?";
		plantilla.update(SQL,articulo.getsNombre(),articulo.getsDescripcion(),
						articulo.getsCaracteristica(),articulo.getsMarca(),
						articulo.getnAño(),articulo.getnPrecio(),
						articulo.getsImgURL1(),articulo.getsImgURL2(),
						articulo.getsTag(), articulo.getnIdCategoria(),articulo.getnPromocion(), articulo.getnId());
		return result;
	}

	@Override
	public Articulo obtenerPorId(int nId) {
		System.out.println("entro al dao "+ nId);

		String SQL = "SELECT * FROM articulos where nId = ?";
		try {
			
			return plantilla.queryForObject(SQL, new ArticuloToMapper(),nId);
			
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
