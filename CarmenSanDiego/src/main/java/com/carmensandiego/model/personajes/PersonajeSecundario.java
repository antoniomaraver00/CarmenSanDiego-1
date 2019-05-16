package com.carmensandiego.model.personajes;

import java.util.List;

import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public class PersonajeSecundario extends Personaje{
	
	private PistasAcumuladas pistas;

	public PersonajeSecundario() {
		super();
		this.pistas = new PistasAcumuladas();
	}
	
	public PersonajeSecundario(String nombre, String descripcion) {
		super(nombre,descripcion);
		this.pistas = new PistasAcumuladas();
	}
	
	public void acumularPista(Pista pista) {
		this.pistas.acumularPista(pista);
	}
	
	public List<Pista> darPistas(){
		return this.pistas.tirarPistas();
	}

	public void acumularPistas(List<Pista> pistas) {
		this.pistas.acumularPistas(pistas);
	}
}
