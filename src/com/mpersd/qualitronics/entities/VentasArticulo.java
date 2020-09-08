package com.mpersd.qualitronics.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ventas_articulos database table.
 * 
 */
@Entity
@Table(name="ventas_articulos")
@NamedQuery(name="VentasArticulo.findAll", query="SELECT v FROM VentasArticulo v")
public class VentasArticulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nId;

	private int nCantidad;

	private BigDecimal nPrecioArticulo;

	//bi-directional many-to-one association to Venta
	@ManyToOne
	@JoinColumn(name="nIdVenta")
	private Venta venta;

	//bi-directional many-to-one association to Articulo
	@ManyToOne
	@JoinColumn(name="nIdArticulo")
	private Articulo articulo;

	public VentasArticulo() {
	}

	public int getNId() {
		return this.nId;
	}

	public void setNId(int nId) {
		this.nId = nId;
	}

	public int getNCantidad() {
		return this.nCantidad;
	}

	public void setNCantidad(int nCantidad) {
		this.nCantidad = nCantidad;
	}

	public BigDecimal getNPrecioArticulo() {
		return this.nPrecioArticulo;
	}

	public void setNPrecioArticulo(BigDecimal nPrecioArticulo) {
		this.nPrecioArticulo = nPrecioArticulo;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Articulo getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

}