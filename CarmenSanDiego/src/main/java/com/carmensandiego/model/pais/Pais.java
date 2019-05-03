package com.carmensandiego.model.pais;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.model.espacio.Aeropuerto;
import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public abstract class Pais implements Viajable{
	
	protected String nombre;
	
	protected String descripcion;
	
	//TODO: Hacer un mapa
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
		this.espacios.add(new Aeropuerto(this.nombre));
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public List<Espacio> getEspacios() {
		return espacios;
	}

	public PistasAcumuladas getPistasAcumuladas() {
		return pistasAcumuladas;
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
	
	@Override
	public Pais viajeroHaLlegado() {
		return this;
	}
	
	@Override
	public void ubicarViajeroInicialmente(ViajeroInterface viajero) {
		viajero.visitar(this.espacios.get(0));
	}
}
