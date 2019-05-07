package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Piramide;

public class Egipto extends Pais {
	
	public Egipto() {
		super("Egipto","Pais de increibles historias, monumentos exoticos y tesoros antiguos.");
		this.espacios.add(new Piramide());
	}

}
