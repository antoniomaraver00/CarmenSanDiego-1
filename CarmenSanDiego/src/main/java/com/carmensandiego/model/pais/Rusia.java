package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Embajada;

public class Rusia extends Pais {
	
	public Rusia() {
		super("Rusia","Un lugar frio, con muchos monumentos exoticos y tesoros antiguos");
		this.espacios.add(new Embajada());
	}

}
