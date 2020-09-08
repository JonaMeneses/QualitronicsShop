package com.mpersd.quialitronics.model;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Articulo extends EntidadBase{
	@NotNull
	@Length(min = 3,max = 50,message = "El campo es requerido con maximo 50 caracteres")
	private String sNombre;
	@NotNull
	@Length(min = 5,max = 4000,message = "El campo es requerido con maximo 4000 caracteres")
	private String sDescripcion;
	@NotNull
	@Length(min = 5,max = 4000,message = "El campo es requerido con maximo 4000 caracteres")
	private String sCaracteristica;
	@NotNull
	@Length(min = 3,max = 100,message = "El campo es requerido con maximo 100 caracteres")
	private String sMarca;
	@NotNull
	@Min(value = 2010,message = "El minimo permitido es 2010")
	@Max(value = 2030,message = "El maximo permitido es 2030")
	private int nAño;
	@NotNull
	@DecimalMin(value = "0.99",message = "El minimo permitido es $0.99")
	@DecimalMax(value = "999999.99",message = "El maximo permitido es $999999.99")
	private double nPrecio;
	@NotNull
	@Length(min = 3,max = 1000,message = "El campo es requerido con maximo 1000 caracteres")
	private String sImgURL1;
	@NotNull
	@Length(min = 3,max = 1000,message = "El campo es requerido con maximo 1000 caracteres")
	private String sImgURL2;
	@NotNull
	@Length(min = 1,max = 4000,message = "El campo es requerido con maximo 4000 caracteres")
	private String sTag;
	@NotNull
	@Min(value = 1,message = "El minimo permitido es 1")
	private int nIdCategoria;
	private  int nCantidad = 0;
	
	
	
	

	public Articulo() {
		super();
	}


	public Articulo(int nId,String sNombre, String sDescripcion, String sCaracteristica, String sMarca, int nAño,
			double nPrecio,String sImgURL1, String sImgURL2, String sTag,int nIdCategoria,Date dFechaCreacion,boolean bActivo) {
		super(nId,dFechaCreacion,bActivo);
		this.sNombre = sNombre;	
		this.sDescripcion = sDescripcion;
		this.sCaracteristica = sCaracteristica;
		this.sMarca = sMarca;
		this.nAño = nAño;
		this.nPrecio = nPrecio;
		this.sImgURL1 = sImgURL1;
		this.sImgURL2 = sImgURL2;
		this.sTag = sTag;
		this.nIdCategoria = nIdCategoria;
	}

	public String getsNombre() {
		return sNombre;
	}


	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}


	public String getsDescripcion() {
		return sDescripcion;
	}


	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}


	public String getsCaracteristica() {
		return sCaracteristica;
	}


	public void setsCaracteristica(String sCaracteristica) {
		this.sCaracteristica = sCaracteristica;
	}


	public String getsMarca() {
		return sMarca;
	}


	public void setsMarca(String sMarca) {
		this.sMarca = sMarca;
	}


	public int getnAño() {
		return nAño;
	}


	public void setnAño(int nAño) {
		this.nAño = nAño;
	}


	public String getsImgURL1() {
		return sImgURL1;
	}


	public void setsImgURL1(String sImgURL1) {
		this.sImgURL1 = sImgURL1;
	}


	public String getsImgURL2() {
		return sImgURL2;
	}


	public void setsImgURL2(String sImgURL2) {
		this.sImgURL2 = sImgURL2;
	}


	public String getsTag() {
		return sTag;
	}


	public void setsTag(String sTag) {
		this.sTag = sTag;
	}


	public double getnPrecio() {
		return nPrecio;
	}


	public void setnPrecio(double nPrecio) {
		this.nPrecio = nPrecio;
	}


	public int getnIdCategoria() {
		return nIdCategoria;
	}


	public void setnIdCategoria(int nIdCategoria) {
		this.nIdCategoria = nIdCategoria;
	}

	public int getnCantidad() {
		return nCantidad;
	}


	public void setnCantidad(int nCantidad) {
		this.nCantidad = nCantidad;
	}

	
	

}
