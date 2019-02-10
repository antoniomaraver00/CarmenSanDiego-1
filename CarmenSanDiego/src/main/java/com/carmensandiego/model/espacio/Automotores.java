package com.carmensandiego.model.espacio;

import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Automotores extends Espacio{

	public Automotores() {
		this.nombre = "Automotores S.A.";
		this.descripcion = "El mejor lugar donde encontrar tu vehiculo";
		this.personajeSecundario = new PersonajeSecundario("Ricardo","Mecanico General");
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
