package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Piramide;
import com.carmensandiego.model.pista.Pista;

public class Egipto extends Pais {
	
	public Egipto() {
		super("Egipto","Pais de increibles historias, monumentos exoticos y tesoros antiguos.");
		this.espacios.add(new Piramide());
	}

	@Override
	protected void crearPistas() {
		Pista pistaBandera = new Pista("Bandera Roja, Negra y Blanca");
		Pista pistaEscudo = new Pista("Escudo de Aguila dorada");
		Pista pistaPiramides = new Pista("Informacion de la Gran Esfinge");
	}

}
