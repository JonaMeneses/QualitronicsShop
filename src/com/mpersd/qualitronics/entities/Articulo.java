package com.mpersd.qualitronics.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the articulos database table.
 * 
 */
@Entity
@Table(name="articulos")
@NamedQuery(name="Articulo.findAll", query="SELECT a FROM Articulo a")
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nId;

	private byte bActivo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaMod;

	private int nAño;

	private double nPrecio;

	private String sCaracteristicas;

	private String sDescripcion;

	private String sImgURL1;

	private String sImgURL2;

	private String sMarca;

	private String sNnombre;

	private String sTags;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="nIdCategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to VentasArticulo
	@OneToMany(mappedBy="articulo")
	private List<VentasArticulo> ventasArticulos;

	public Articulo() {
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

	public Date getDFechaMod() {
		return this.dFechaMod;
	}

	public void setDFechaMod(Date dFechaMod) {
		this.dFechaMod = dFechaMod;
	}

	public int getNAño() {
		return this.nAño;
	}

	public void setNAño(int nAño) {
		this.nAño = nAño;
	}

	public double getNPrecio() {
		return this.nPrecio;
	}

	public void setNPrecio(double nPrecio) {
		this.nPrecio = nPrecio;
	}

	public String getSCaracteristicas() {
		return this.sCaracteristicas;
	}

	public void setSCaracteristicas(String sCaracteristicas) {
		this.sCaracteristicas = sCaracteristicas;
	}

	public String getSDescripcion() {
		return this.sDescripcion;
	}

	public void setSDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}

	public String getSImgURL1() {
		return this.sImgURL1;
	}

	public void setSImgURL1(String sImgURL1) {
		this.sImgURL1 = sImgURL1;
	}

	public String getSImgURL2() {
		return this.sImgURL2;
	}

	public void setSImgURL2(String sImgURL2) {
		this.sImgURL2 = sImgURL2;
	}

	public String getSMarca() {
		return this.sMarca;
	}

	public void setSMarca(String sMarca) {
		this.sMarca = sMarca;
	}

	public String getSNnombre() {
		return this.sNnombre;
	}

	public void setSNnombre(String sNnombre) {
		this.sNnombre = sNnombre;
	}

	public String getSTags() {
		return this.sTags;
	}

	public void setSTags(String sTags) {
		this.sTags = sTags;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<VentasArticulo> getVentasArticulos() {
		return this.ventasArticulos;
	}

	public void setVentasArticulos(List<VentasArticulo> ventasArticulos) {
		this.ventasArticulos = ventasArticulos;
	}

	public VentasArticulo addVentasArticulo(VentasArticulo ventasArticulo) {
		getVentasArticulos().add(ventasArticulo);
		ventasArticulo.setArticulo(this);

		return ventasArticulo;
	}

	public VentasArticulo removeVentasArticulo(VentasArticulo ventasArticulo) {
		getVentasArticulos().remove(ventasArticulo);
		ventasArticulo.setArticulo(null);

		return ventasArticulo;
	}

}