package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.lugar.Automotores;
import com.carmensandiego.model.pista.Pista;

public class Alemania extends Pais {
	
	public Alemania() {
		super("Alemania","Pais de viejas costumbres, expertos en ingenieria automotor. "
				+ "Su capital, Berlin, es una de las mas seguros del mundo. Nada que ocurra aqui no esta monitoreado.");
		lugares.agregarLugar(new Automotores());
	}

	@Override
	public List<Pista> crearMisPistas() {
		List<Pista> pistasDelPais = new ArrayList<Pista>();
		Pista pistaBandera = new Pista("Bandera Amarilla, Roja y Negra");
		pistasDelPais.add(pistaBandera);
		Pista pistaAuto = new Pista("Conducia un auto de alta gama");
		pistasDelPais.add(pistaAuto);
		Pista pistaSeguridad = new Pista("Inteligencia a determinado que buscaba un software de reconocimiento facial");
		pistasDelPais.add(pistaSeguridad);
		return pistasDelPais;
	}

}
