package com.carmensandiego.alerta;

/**
 * Representa una alerta para el jugador.
 * @author mperez
 */
public class Alerta {
	
	private String mensaje;
	
	public Alerta() {
		super();
		this.mensaje="";
	}
	
	public Alerta(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

}
