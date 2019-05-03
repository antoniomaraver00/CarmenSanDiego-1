package com.carmensandiego.model.espacio;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class ClubNocturno extends Espacio{

	public ClubNocturno() {
		super();
		this.nombre = "Club Nocturno";
		this.descripcion = "Club nocturno para mayores de 18 años";
		this.personajeSecundario = new PersonajeSecundario("Ban Boom","Relaciones Publicas");
	}

}
