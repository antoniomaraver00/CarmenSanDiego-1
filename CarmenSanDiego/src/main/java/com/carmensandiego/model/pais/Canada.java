package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Embajada;

public class Canada extends Pais{
	
	public Canada() {
		super("Canada","Canada es una democracia parlamentaria que forma parte de la Commonwealth. Su capital, Ottawa, esta situada en la provincia de Ontario.");
		this.espacios.add(new Embajada());
	}

	@Override
	protected void crearPistas() {
		// TODO Auto-generated method stub
		
	}

}
