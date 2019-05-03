package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.ClubNocturno;
import com.carmensandiego.model.espacio.Home;

public class Argentina extends Pais {
	
	public Argentina() {
		super("Argentina","Pais de Origen. Vivís acá.");
		this.espacios.add(new Home());
		this.espacios.add(new ClubNocturno());
	}

}
