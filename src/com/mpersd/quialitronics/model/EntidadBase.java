package com.mpersd.quialitronics.model;

import java.util.Date;

public class EntidadBase {
	
	public int nId = 0;
	public Date dFechaCreacion;
	public boolean bActivo=true;
	
	public EntidadBase() {
		// TODO Auto-generated constructor stub
	}

	public EntidadBase(int nId, Date dFechaCreacion, boolean bActivo) {
		super();
		this.nId = nId;
		this.dFechaCreacion = dFechaCreacion;
		this.bActivo = bActivo;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public Date getdFechaCreacion() {
		return dFechaCreacion;
	}

	public void setdFechaCreacion(Date dFechaCreacion) {
		this.dFechaCreacion = dFechaCreacion;
	}

	public Boolean getbActivo() {
		return bActivo;
	}

	public void setbActivo(Boolean bActivo) {
		this.bActivo = bActivo;
	}


	

}
