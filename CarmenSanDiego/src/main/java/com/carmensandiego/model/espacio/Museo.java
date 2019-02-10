package com.carmensandiego.model.espacio;

import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Museo extends Espacio{
	
	public Museo() {
		super();
		this.nombre = "Museo";
		this.descripcion = "Espacio Nacional de Artes y Ciencias";
		this.personajeSecundario = new PersonajeSecundario("Raul","Guardia de seguridad del museo");
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
