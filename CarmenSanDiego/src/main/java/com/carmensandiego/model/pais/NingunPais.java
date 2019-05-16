package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.pista.Pista;

public class NingunPais extends Pais {
	
	public NingunPais() {
		super();
	}

	@Override
	public List<Pista> crearMisPistas() {
		//Devuelve una lista vacia.
		return new ArrayList<Pista>();
	}
	
	@Override
	public Boolean esValido() {
		return false;
	}

}
