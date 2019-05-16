package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.lugar.Piramide;
import com.carmensandiego.model.pista.Pista;

public class Egipto extends Pais {
	
	public Egipto() {
		super("Egipto","Pais de increibles historias, monumentos exoticos y tesoros antiguos.");
		lugares.agregarLugar(new Piramide());
	}

	@Override
	public List<Pista> crearMisPistas() {
		List<Pista> pistasDelPais = new ArrayList<Pista>();
		Pista pistaBandera = new Pista("Bandera Roja, Negra y Blanca");
		pistasDelPais.add(pistaBandera);
		Pista pistaEscudo = new Pista("Escudo de Aguila dorada");
		pistasDelPais.add(pistaEscudo);
		Pista pistaPiramides = new Pista("Informacion de la Gran Esfinge");
		pistasDelPais.add(pistaPiramides);
		return pistasDelPais;
	}

	@Override
	public Boolean esValido() {
		return true;
	}

}
