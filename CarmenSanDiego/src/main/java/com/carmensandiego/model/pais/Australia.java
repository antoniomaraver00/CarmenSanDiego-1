package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Museo;
import com.carmensandiego.model.espacio.PlazaMunicipal;

public class Australia extends Pais {
	
	public Australia() {
		super("Australia","Territorio de los canguros, gran diversidad de habitats.");
		this.espacios.add(new Museo());
		this.espacios.add(new PlazaMunicipal());
	}

}
