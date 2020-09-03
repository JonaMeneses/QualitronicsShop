package com.mpersd.quialitronics.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Usuario extends EntidadBase{
	
	@NotNull
	@Length(min = 3,max = 50,message = "El campo es requerido con maximo 50 caracteres")
	private String sEmail;
	@NotNull
	@Length(min = 3,max = 50,message = "El campo es requerido con maximo 50 caracteres")
	private String sContraseña;
	@NotNull
	@Length(min = 3,max = 50,message = "El campo es requerido con maximo 50 caracteres")
	private String sNombre;
	@NotNull
	@Length(min = 3,max = 50,message = "El campo es requerido con maximo 50 caracteres")
	private String sPaterno;
	@NotNull
	@Length(min = 3,max = 50,message = "El campo es requerido con maximo 50 caracteres")
	private String sMaterno;
	@NotNull
	@Min(value = 18,message = "El minimo permitido es 18 años")
	@Max(value = 99,message = "El maximo permitido es 99 años")
	private int nEdad;
	@NotNull
	@Min(value = 1,message = "El minimo permitido es 18 años")
	@Max(value = 99,message = "El maximo permitido es 99 años")
	private int nIdRol;
	private String sNombreRol;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int nId,String sEmail, String sContraseña, String sNombre, String sPaterno,
					String sMaterno, int nEdad,int nIdRol,String sNombreRol, Date dFechaCreacion,boolean bActivo) {
		super(nId,dFechaCreacion,bActivo);
		this.sEmail = sEmail;
		this.sContraseña = sContraseña;
		this.sNombre = sNombre;
		this.sPaterno = sPaterno;
		this.sMaterno = sMaterno;
		this.nEdad = nEdad;
		this.nIdRol = nIdRol;
		this.sNombreRol = sNombreRol;
	}
	

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsContraseña() {
		return sContraseña;
	}

	public void setsContraseña(String sContraseña) {
		this.sContraseña = sContraseña;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsPaterno() {
		return sPaterno;
	}

	public void setsPaterno(String paterno) {
		sPaterno = paterno;
	}

	public String getsMaterno() {
		return sMaterno;
	}

	public void setsMaterno(String sMaterno) {
		this.sMaterno = sMaterno;
	}

	public int getnEdad() {
		return nEdad;
	}

	public void setnEdad(int nEdad) {
		this.nEdad = nEdad;
	}
	public int getnIdRol() {
		return nIdRol;
	}

	public void setnIdRol(int nIdRol) {
		this.nIdRol = nIdRol;
	}

	public String getsNombreRol() {
		return sNombreRol;
	}

	public void setsNombreRol(String sNombreRol) {
		this.sNombreRol = sNombreRol;
	}
	
	

}
