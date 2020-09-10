package com.mpersd.qualitronics.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nId;

	private int nCantidad;

	private Double nPrecioArticulo;

	//bi-directional many-to-one association to Venta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nIdVenta")
	@JsonIgnore
	private Venta venta;

	//bi-directional many-to-one association to Articulo
	@ManyToOne(fetch = FetchType.EAGER)
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

	public Double getNPrecioArticulo() {
		return this.nPrecioArticulo;
	}

	public void setNPrecioArticulo(Double nPrecioArticulo) {
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