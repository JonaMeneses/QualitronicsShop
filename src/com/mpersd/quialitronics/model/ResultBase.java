package com.mpersd.quialitronics.model;

public class ResultBase {

	
	private String mensajeRespuesta = "OK";
	private int estadoRespuesta = 100;
	private Object objetoRespuesta;

	public ResultBase() {
		// TODO Auto-generated constructor stub
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public int getEstadoRespuesta() {
		return estadoRespuesta;
	}

	public void setEstadoRespuesta(int estadoRespuesta) {
		this.estadoRespuesta = estadoRespuesta;
	}

	public Object getObjetoRespuesta() {
		return objetoRespuesta;
	}

	public void setObjetoRespuesta(Object objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}
	
	

}
