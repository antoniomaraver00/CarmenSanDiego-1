package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Automotores;
import com.carmensandiego.model.pista.Pista;

public class Alemania extends Pais {
	
	public Alemania() {
		super("Alemania","Pais de viejas costumbres, expertos en ingenieria automotor. "
				+ "Su capital, Berlin, es una de las mas seguros del mundo. Nada que ocurra aqui no esta monitoreado.");
		this.espacios.add(new Automotores());
	}

	@Override
	protected void crearPistas() {
		Pista pistaBandera = new Pista("Bandera Amarilla, Roja y Negra");
		Pista pistaAuto = new Pista("Conducia un auto de alta gama");
		Pista pistaSeguridad = new Pista("Inteligencia a determinado que buscaba un software de reconocimiento facial");
	}

}
