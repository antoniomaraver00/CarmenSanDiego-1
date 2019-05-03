package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Automotores;

public class Alemania extends Pais {
	
	public Alemania() {
		super("Alemania","Pais de viejas costumbres, expertos en ingenieria automotor");
		this.espacios.add(new Automotores());
	}

}
