package com.carmensandiego.model.lugar;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Embajada extends Lugar{
	
	public Embajada() {
		super();
		this.nombre = "Embajada";
		this.descripcion = "Embajada de Argentina";
		this.personajeSecundario = new PersonajeSecundario("Celia","Embajadora Residencial de Argentina");
	}



}
