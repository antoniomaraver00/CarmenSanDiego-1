package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.ClubNocturno;
import com.carmensandiego.model.espacio.Home;
import com.carmensandiego.model.pista.Pista;

public class Argentina extends Pais {
	
	public Argentina() {
		super("Argentina","Pais amantes del futbol, salidas nocturnas, el mate. Su capital, Ciudad Autonoma de Buenos Aires es considerada una de las ciudades"
				+ " mas bellas del mundo. Vivís acá.");
		this.espacios.add(new Home());
		this.espacios.add(new ClubNocturno());
	}

	@Override
	protected void crearPistas() {
		Pista pistaBandera = new Pista("Bandera Celeste y Blanca");
		Pista pistaEscudo = new Pista("Su escudo era un dorado y flameante corazon");
		Pista pistaFutbol = new Pista("Informacion sobre equipos de futbol y canciones populares");
	}

}
