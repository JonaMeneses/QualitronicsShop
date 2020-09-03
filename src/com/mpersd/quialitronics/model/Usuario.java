package com.mpersd.quialitronics.model;

import java.util.Date;

public class Usuario extends EntidadBase{
	
	private String sEmail;
	private String sContrase�a;
	private String sNombre;
	private String Paterno;
	private String sMaterno;
	private int nEdad;
	
	public Usuario(int nId,String sEmail, String sContrase�a, String sNombre, String paterno,
					String sMaterno, int nEdad, Date dFechaCreacion,boolean bActivo) {
		super(nId,dFechaCreacion,bActivo);
		this.sEmail = sEmail;
		this.sContrase�a = sContrase�a;
		this.sNombre = sNombre;
		Paterno = paterno;
		this.sMaterno = sMaterno;
		this.nEdad = nEdad;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsContrase�a() {
		return sContrase�a;
	}

	public void setsContrase�a(String sContrase�a) {
		this.sContrase�a = sContrase�a;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getPaterno() {
		return Paterno;
	}

	public void setPaterno(String paterno) {
		Paterno = paterno;
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
	
	
	

}
