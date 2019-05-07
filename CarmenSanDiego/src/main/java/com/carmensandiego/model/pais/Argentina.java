package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.ClubNocturno;
import com.carmensandiego.model.espacio.Home;

public class Argentina extends Pais {
	
	public Argentina() {
		super("Argentina","Pais amantes del futbol, salidas nocturnas, el mate. Su capital, Ciudad Autonoma de Buenos Aires es considerada una de las ciudades"
				+ " mas bellas del mundo. Vivís acá.");
		this.espacios.add(new Home());
		this.espacios.add(new ClubNocturno());
	}

}
