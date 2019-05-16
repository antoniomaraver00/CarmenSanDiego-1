package com.carmensandiego.model.lugar;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class ClubNocturno extends Lugar{

	public ClubNocturno() {
		super();
		this.nombre = "Club Nocturno";
		this.descripcion = "Club nocturno para mayores de 18 a�os";
		this.personajeSecundario = new PersonajeSecundario("Ban Boom","Relaciones Publicas");
	}

}
