package com.carmensandiego.model.espacio;

import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Embajada extends Espacio{
	
	public Embajada() {
		super();
		this.nombre = "Embajada";
		this.descripcion = "Embajada de Argentina";
		this.personajeSecundario = new PersonajeSecundario("Celia","Embajadora Residencial de Argentina");
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
