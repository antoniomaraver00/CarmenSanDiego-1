package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.lugar.Museo;
import com.carmensandiego.model.lugar.PlazaMunicipal;
import com.carmensandiego.model.pista.Pista;

public class Australia extends Pais {
	
	public Australia() {
		super("Australia","Territorio de los canguros, gran diversidad de habitats.");
		lugares.agregarLugar(new Museo());
		lugares.agregarLugar(new PlazaMunicipal());
	}

	@Override
	public List<Pista> crearMisPistas() {
		List<Pista> pistasDelPais = new ArrayList<Pista>();
		Pista pistaBandera = new Pista("Bandera Azul, Roja y Blanca");
		pistasDelPais.add(pistaBandera);
		Pista pistaEscudo = new Pista("Su escudo esta compuesto por un Canguro y un Emu");
		pistasDelPais.add(pistaEscudo);
		Pista pistAnimales = new Pista("Informacion de diversos animales exoticos");
		pistasDelPais.add(pistAnimales);
		return pistasDelPais;
	}

}
