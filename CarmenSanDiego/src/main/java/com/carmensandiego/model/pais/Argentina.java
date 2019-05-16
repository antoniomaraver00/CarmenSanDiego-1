package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.lugar.ClubNocturno;
import com.carmensandiego.model.lugar.Home;
import com.carmensandiego.model.pista.Pista;

public class Argentina extends Pais {
	
	public Argentina() {
		super("Argentina","Pais amantes del futbol, salidas nocturnas, el mate. Su capital, Ciudad Autonoma de Buenos Aires es considerada una de las ciudades"
				+ " mas bellas del mundo. Vivís acá.");
		lugares.agregarLugar(new Home());
		lugares.agregarLugar(new ClubNocturno());
	}

	@Override
	public List<Pista> crearMisPistas() {
		List<Pista> pistasDelPais = new ArrayList<Pista>();
		Pista pistaBandera = new Pista("Bandera Celeste y Blanca");
		pistasDelPais.add(pistaBandera);
		Pista pistaEscudo = new Pista("Su escudo era un dorado y flameante corazon");
		pistasDelPais.add(pistaEscudo);
		Pista pistaFutbol = new Pista("Informacion sobre equipos de futbol y canciones populares");
		pistasDelPais.add(pistaFutbol);
		return pistasDelPais;
	}
	
	@Override
	public Boolean esValido() {
		return true;
	}

}
