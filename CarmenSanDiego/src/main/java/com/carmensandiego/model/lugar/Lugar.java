package com.carmensandiego.model.lugar;

import java.util.List;

import com.carmensandiego.model.interfaz.Viajero;
import com.carmensandiego.model.personajes.PersonajeSecundario;
import com.carmensandiego.model.pista.Pista;

public abstract class Lugar {
	
	protected String id;
	
	protected String nombre;
	
	protected String descripcion;
	
	protected PersonajeSecundario personajeSecundario;
	
	protected Viajero visita;

	public Lugar() {
		this.id = "";
		this.nombre = "";
		this.descripcion = "";
		this.personajeSecundario = new PersonajeSecundario();
	}
	
	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void informarPistas(List<Pista> pistas) {
		personajeSecundario.acumularPistas(pistas);
	}
	
	public void informarPista(Pista pista) {
		personajeSecundario.acumularPista(pista);
	}
	
	public List<Pista> darPistas() {
		return personajeSecundario.darPistas();
	}
	
	//TODO: Borrar o que haga otra cosa
	public List<Pista> serVisitadoPorProtagonista() {
		return this.personajeSecundario.darPistas();
	}

	//TODO: Borrar o que haga otra cosa
	public void serVisitadoPorAntagonista(List<Pista> pistasDelAntagonista) {
		this.personajeSecundario.acumularPistas(pistasDelAntagonista);
	}
	
	//TODO: que haga otra cosa o vuela
	public Lugar serVisitado() {
		return this;
	}

}
