package com.carmensandiego.model.espacio;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Piramide extends Espacio{
	
	public Piramide() {
		super();
		this.nombre = "Piramide";
		this.descripcion = "Ruina antigua.";
		this.personajeSecundario = new PersonajeSecundario("Samid","Guia turistico.");
	}

}
