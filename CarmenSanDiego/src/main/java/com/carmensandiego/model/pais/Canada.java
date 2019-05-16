package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.lugar.Embajada;
import com.carmensandiego.model.pista.Pista;

public class Canada extends Pais{
	
	public Canada() {
		super("Canada","Canada es una democracia parlamentaria que forma parte de la Commonwealth. Su capital, Ottawa, esta situada en la provincia de Ontario.");
		lugares.agregarLugar(new Embajada());
	}

	@Override
	public List<Pista> crearMisPistas() {
		return new ArrayList<Pista>();
		
	}

}
