package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Museo;
import com.carmensandiego.model.espacio.PlazaMunicipal;

public class Espania extends Pais {
	
	public Espania() {
		super("España","Pais del flamenco, las corridas de toros y las fiestas");
		this.espacios.add(new Museo());
		this.espacios.add(new PlazaMunicipal());
	}

}
