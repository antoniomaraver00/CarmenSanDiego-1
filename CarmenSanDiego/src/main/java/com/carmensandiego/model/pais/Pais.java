package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public abstract class Pais implements Viajable{
	
	protected String nombre;
	
	protected String descripcion;
	
	protected List<Espacio> espacios;
	
	protected PistasAcumuladas pistasAcumuladas;
	
	public Pais() {
		this.nombre = "";
		this.descripcion = "";
		this.espacios = new ArrayList<Espacio>();
		this.pistasAcumuladas = new PistasAcumuladas();
	}
	
	public Pais(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.espacios = new ArrayList<Espacio>();
		this.pistasAcumuladas = new PistasAcumuladas();
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
	
	public void agregarEspacio(Espacio espacio) {
		this.espacios.add(espacio);
	}
	
	public void agregarPista(Pista pista) {
		this.pistasAcumuladas.acumularPista(pista);
	}
	
	@Override
	public List<Pista> protagonistaHaLlegado() {
		return this.pistasAcumuladas.tirarPistas();
	}

	@Override
	public void antagonistaHaLlegado(List<Pista> pistas) {
		this.pistasAcumuladas.acumularPistas(pistas);		
	}

	
}