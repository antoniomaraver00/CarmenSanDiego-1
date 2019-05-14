package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Museo;
import com.carmensandiego.model.espacio.PlazaMunicipal;
import com.carmensandiego.model.pista.Pista;

public class Australia extends Pais {
	
	public Australia() {
		super("Australia","Territorio de los canguros, gran diversidad de habitats.");
		this.espacios.add(new Museo());
		this.espacios.add(new PlazaMunicipal());
	}

	@Override
	protected void crearPistas() {
		Pista pistaBandera = new Pista("Bandera Azul, Roja y Blanca");
		Pista pistaEscudo = new Pista("Su escudo esta compuesto por un Canguro y un Emu");
	}

}
