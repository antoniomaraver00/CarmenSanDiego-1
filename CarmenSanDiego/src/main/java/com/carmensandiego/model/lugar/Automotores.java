package com.carmensandiego.model.lugar;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Automotores extends Lugar{

	public Automotores() {
		super();
		this.nombre = "Automotores S.A.";
		this.descripcion = "El mejor lugar donde encontrar tu vehiculo";
		this.personajeSecundario = new PersonajeSecundario("Ricardo","Mecanico General");
	}

}
