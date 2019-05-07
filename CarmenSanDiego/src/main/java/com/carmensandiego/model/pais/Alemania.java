package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Automotores;

public class Alemania extends Pais {
	
	public Alemania() {
		super("Alemania","Pais de viejas costumbres, expertos en ingenieria automotor. "
				+ "Su capital, Berlin, es una de las mas seguros del mundo. Nada que ocurra aqui no esta monitoreado.");
		this.espacios.add(new Automotores());
	}

}
