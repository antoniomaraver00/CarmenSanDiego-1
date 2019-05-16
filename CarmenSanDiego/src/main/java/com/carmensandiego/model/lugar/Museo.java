package com.carmensandiego.model.lugar;

import com.carmensandiego.model.personajes.PersonajeSecundario;

public class Museo extends Lugar{
	
	public Museo() {
		super();
		this.nombre = "Museo";
		this.descripcion = "Espacio Nacional de Artes y Ciencias";
		this.personajeSecundario = new PersonajeSecundario("Raul","Guardia de seguridad del museo");
	}
}
