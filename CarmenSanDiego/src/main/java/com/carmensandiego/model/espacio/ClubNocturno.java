package com.carmensandiego.model.espacio;

import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.personajes.PersonajeSecundario;

public class ClubNocturno extends Espacio{

	public ClubNocturno() {
		this.nombre = "Club Nocturno";
		this.descripcion = "Club nocturno para mayores de 18 años";
		this.personajeSecundario = new PersonajeSecundario("Ban Boom","Relaciones Publicas");
	}

	@Override
	public void serVisitado(ViajeroInterface viajero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void despedirVisita() {
		// TODO Auto-generated method stub
		
	}
	
}
