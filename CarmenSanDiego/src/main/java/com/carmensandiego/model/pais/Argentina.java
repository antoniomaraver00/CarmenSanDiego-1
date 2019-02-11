package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.ClubNocturno;
import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.espacio.Home;

public class Argentina extends Pais {
	
	public Argentina() {
		super("Argentina","Pais de Origen. Vivís aca.");
		Espacio home = new Home();
		this.espacios.add(home);
		Espacio clubNocturo = new ClubNocturno();
		this.espacios.add(clubNocturo);
	}

}
