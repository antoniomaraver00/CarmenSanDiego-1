package com.carmensandiego.model;

import java.util.HashMap;
import java.util.Map;

import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.personajes.Protagonista;

/**
 * Representa todo el mundo contenido en la aplicacion
 * @author martin
 *
 */
public class Mundo {
	
	private static Mundo mundo;
	
	private Map<String,Pais> paises;
	private Protagonista protagonista;
	
	private Mundo() {
		this.paises = new HashMap<String,Pais>();
		this.protagonista = new Protagonista();
	}
	
	public static  Mundo getSingletonInstance() {
		if (mundo == null)
			mundo = new Mundo();
		return mundo;
	}
	
	public void agregarPaises(Map<String,Pais> paises) {
		this.paises = paises;
	}

	public void crearProtagonista(String protagonista) {
		this.protagonista.setNombre(protagonista);
		this.protagonista.setDescripcion("El mejor detective de todos los tiempos");
	}
	
	public Protagonista getProtagonista() {
		return this.protagonista;
	}

}
