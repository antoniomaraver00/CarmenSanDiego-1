package com.carmensandiego.model.pista;

public class Pista {
	
	private String mensaje;
	
	public Pista() {
		this.mensaje = "";
	}
	
	public Pista(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
