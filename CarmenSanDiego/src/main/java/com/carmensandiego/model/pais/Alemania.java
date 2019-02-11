package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Automotores;
import com.carmensandiego.model.espacio.Espacio;

public class Alemania extends Pais {
	
	public Alemania() {
		super("Alemania","Pais de viejas costumbres, expertos en ingenieria automotor");
		Espacio automotores = new Automotores();
		this.espacios.add(automotores);
	}

}
