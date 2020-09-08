package com.mpersd.qualitronics.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ventas database table.
 * 
 */
@Entity
@Table(name="ventas")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dFechaAlta;

	private double nTotal;

	private String sFolio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="nIdUsuario")
	private Usuario usuario;

	//bi-directional many-to-one association to VentasArticulo
	@OneToMany(mappedBy="venta")
	private List<VentasArticulo> ventasArticulos;

	public Venta() {
	}

	public int getNId() {
		return this.nId;
	}

	public void setNId(int nId) {
		this.nId = nId;
	}

	public Date getDFechaAlta() {
		return this.dFechaAlta;
	}

	public void setDFechaAlta(Date dFechaAlta) {
		this.dFechaAlta = dFechaAlta;
	}

	public double getNTotal() {
		return this.nTotal;
	}

	public void setNTotal(double nTotal) {
		this.nTotal = nTotal;
	}

	public String getSFolio() {
		return this.sFolio;
	}

	public void setSFolio(String sFolio) {
		this.sFolio = sFolio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<VentasArticulo> getVentasArticulos() {
		return this.ventasArticulos;
	}

	public void setVentasArticulos(List<VentasArticulo> ventasArticulos) {
		this.ventasArticulos = ventasArticulos;
	}

	public VentasArticulo addVentasArticulo(VentasArticulo ventasArticulo) {
		getVentasArticulos().add(ventasArticulo);
		ventasArticulo.setVenta(this);

		return ventasArticulo;
	}

	public VentasArticulo removeVentasArticulo(VentasArticulo ventasArticulo) {
		getVentasArticulos().remove(ventasArticulo);
		ventasArticulo.setVenta(null);

		return ventasArticulo;
	}

}