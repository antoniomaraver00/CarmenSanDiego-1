package com.carmensandiego.model.personajes;

public abstract class Personaje {
	
	protected String nombre;
	
	protected String descripcion;
	
	public Personaje() {
		this.nombre = "";
		this.descripcion = "";
	}
	
	public Personaje(String nombre,String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	
}
