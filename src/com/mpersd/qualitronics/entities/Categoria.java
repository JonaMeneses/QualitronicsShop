package com.mpersd.qualitronics.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the categorias database table.
 * 
 */
@Entity
@Table(name="categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nId;

	private byte bActivo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaAlta;

	private String sNnombre;

	//bi-directional many-to-one association to Articulo
	@OneToMany(mappedBy="categoria")
	private List<Articulo> articulos;

	public Categoria() {
	}

	public int getNId() {
		return this.nId;
	}

	public void setNId(int nId) {
		this.nId = nId;
	}

	public byte getBActivo() {
		return this.bActivo;
	}

	public void setBActivo(byte bActivo) {
		this.bActivo = bActivo;
	}

	public Date getDFechaAlta() {
		return this.dFechaAlta;
	}

	public void setDFechaAlta(Date dFechaAlta) {
		this.dFechaAlta = dFechaAlta;
	}

	public String getSNnombre() {
		return this.sNnombre;
	}

	public void setSNnombre(String sNnombre) {
		this.sNnombre = sNnombre;
	}

	public List<Articulo> getArticulos() {
		return this.articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Articulo addArticulo(Articulo articulo) {
		getArticulos().add(articulo);
		articulo.setCategoria(this);

		return articulo;
	}

	public Articulo removeArticulo(Articulo articulo) {
		getArticulos().remove(articulo);
		articulo.setCategoria(null);

		return articulo;
	}

}