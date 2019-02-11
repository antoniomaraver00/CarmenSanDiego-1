package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Automotores;
import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.interfaz.ViajeroInterface;

public class Alemania extends Pais {
	
	public Alemania() {
		super("Alemania","Pais de viejas costumbres, expertos en ingenieria automotor");
		Espacio automotores = new Automotores();
		this.espacios.add(automotores);
	}

	@Override
	public void viajeroHaLlegado(ViajeroInterface viajero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viajeroSeHaIdo(ViajeroInterface viajero) {
		// TODO Auto-generated method stub
		
	}

}
