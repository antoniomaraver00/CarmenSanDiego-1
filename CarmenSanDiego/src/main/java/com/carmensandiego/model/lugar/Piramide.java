package com.carmensandiego.model.lugar;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Piramide extends Lugar{
	
	public Piramide() {
		super();
		this.nombre = "Piramide";
		this.descripcion = "Ruina antigua.";
		this.personajeSecundario = new PersonajeSecundario("Samid","Guia turistico.");
	}

}
