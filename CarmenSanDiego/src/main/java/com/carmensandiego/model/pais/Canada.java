package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.espacio.Embajada;
import com.carmensandiego.model.pista.Pista;

public class Canada extends Pais{
	
	public Canada() {
		super("Canada","Canada es una democracia parlamentaria que forma parte de la Commonwealth. Su capital, Ottawa, esta situada en la provincia de Ontario.");
		this.espacios.add(new Embajada());
	}

	@Override
	public List<Pista> crearPistas() {
		return new ArrayList<Pista>();
		
	}

}
