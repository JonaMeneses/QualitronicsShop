package com.mpersd.quialitronics.model;

import java.util.ArrayList;
import java.util.List;

public class Compra {
	
	private Usuario usuario;
	private List<Articulo> articulos = new ArrayList<Articulo>();
	private double nTotal = 0d;

	public Compra(Usuario usuario, List<Articulo> articulos,double nTotal) {
		super();
		this.usuario = usuario;
		this.articulos = articulos;
		this.nTotal = nTotal;
	}

	

	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	public void setArticulo(Articulo articulo) {
		if(articulo != null) {
			this.articulos.add(articulo);
		}
	}
	
	public void deleteArticulo(int id) {
		System.out.println("total:" + articulos.size());
		this.articulos.removeIf(articulo -> articulo.nId == id);
		
	}
	
	public double getTotal() {
		double total = 0;
		for (Articulo articulo : articulos) {
			total += articulo.getnPrecio() * articulo.getnCantidad();
		}
		this.nTotal = total;
		
		return this.nTotal;
	}	
	
	public double getnTotal() {
		return nTotal;
	}

	public void setnTotal(double nTotal) {
		this.nTotal = nTotal;
	}

}
