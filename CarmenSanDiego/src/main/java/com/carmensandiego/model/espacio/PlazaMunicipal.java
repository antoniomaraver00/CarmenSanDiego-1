package com.carmensandiego.model.espacio;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class PlazaMunicipal extends Espacio {
	
	public PlazaMunicipal() {
		super();
		this.nombre = "Plaza Municipal";
		this.descripcion = "Plaza de entretenimiento y cultura general";
		this.personajeSecundario = new PersonajeSecundario("Jorge","Guardia de la plaza");
	}

}
