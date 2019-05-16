package com.carmensandiego.model.pista;

public class Pista {
	
	private String mensaje;
	private Boolean visto;
	
	public Pista() {
		this.mensaje = "";
		this.visto = false;
	}
	
	public Pista(String mensaje) {
		this.mensaje = mensaje;
		this.visto = false;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public Boolean getVisto() {
		return this.visto;
	}
	
	public void verPista() {
		this.visto = true;
	}

}
