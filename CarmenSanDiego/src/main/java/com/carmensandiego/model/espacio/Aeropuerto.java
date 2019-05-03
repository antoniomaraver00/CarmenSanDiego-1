package com.carmensandiego.model.espacio;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Aeropuerto extends Espacio {
	
	public Aeropuerto(String nombrePais) {
		super();
		this.nombre = "Aeropuerto";
		this.descripcion = "Aeropuerto de "+ nombrePais;
		this.personajeSecundario = new PersonajeSecundario("Ayudante de Aeropuerto","Ayudante de Aeropuerto");
	}

}
