package com.carmensandiego.model.espacio;

import java.util.List;

import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.interfaz.Visitable;
import com.carmensandiego.model.personajes.PersonajeSecundario;
import com.carmensandiego.model.pista.Pista;

public abstract class Espacio implements Visitable{
	
	protected String nombre;
	
	protected String descripcion;
	
	protected PersonajeSecundario personajeSecundario;
	
	protected ViajeroInterface visita;

	public Espacio() {
		this.nombre = "";
		this.descripcion = "";
		this.personajeSecundario = new PersonajeSecundario();
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
		this.personajeSecundario.agregarPistas(pistas);
	}
	
	public void informarPista(Pista pista) {
		this.personajeSecundario.agregarPista(pista);
	}
	
	@Override
	public List<Pista> serVisitadoPorProtagonista() {
		return this.personajeSecundario.darPistas();
	}

	@Override
	public void serVisitadoPorAntagonista(List<Pista> pistasDelAntagonista) {
		this.personajeSecundario.agregarPistas(pistasDelAntagonista);
	}

}
