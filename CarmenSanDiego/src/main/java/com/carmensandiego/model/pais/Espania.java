package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.espacio.Museo;
import com.carmensandiego.model.espacio.PlazaMunicipal;
import com.carmensandiego.model.interfaz.ViajeroInterface;

public class Espania extends Pais {
	
	public Espania() {
		super("España","Pais del flamenco, las corridas de toros y las fiestas");
		Espacio plazaMunicipal = new PlazaMunicipal();
		Espacio museo = new Museo();
		this.espacios.add(museo);
		this.espacios.add(plazaMunicipal);
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
