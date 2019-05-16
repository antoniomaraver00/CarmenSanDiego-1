package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.espacio.Piramide;
import com.carmensandiego.model.pista.Pista;

public class Egipto extends Pais {
	
	public Egipto() {
		super("Egipto","Pais de increibles historias, monumentos exoticos y tesoros antiguos.");
		this.espacios.add(new Piramide());
	}

	@Override
	public List<Pista> crearPistas() {
		List<Pista> pistasDelPais = new ArrayList<Pista>();
		Pista pistaBandera = new Pista("Bandera Roja, Negra y Blanca");
		pistasDelPais.add(pistaBandera);
		Pista pistaEscudo = new Pista("Escudo de Aguila dorada");
		pistasDelPais.add(pistaEscudo);
		Pista pistaPiramides = new Pista("Informacion de la Gran Esfinge");
		pistasDelPais.add(pistaPiramides);
		return pistasDelPais;
	}

}
