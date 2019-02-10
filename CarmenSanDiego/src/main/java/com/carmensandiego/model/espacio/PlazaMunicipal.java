package com.carmensandiego.model.espacio;

import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.personajes.PersonajeSecundario;

public class PlazaMunicipal extends Espacio {
	
	public PlazaMunicipal() {
		this.nombre = "Plaza Municipal";
		this.descripcion = "Plaza de entretenimiento y cultura general";
		this.personajeSecundario = new PersonajeSecundario("Jorge","Guardia de la plaza");
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
