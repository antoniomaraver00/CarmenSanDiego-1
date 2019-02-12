package com.carmensandiego.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.carmensandiego.model.espacio.Espacio;
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
	
	public Pais getPais(String id) {
		return paises.get(id);
	}
	
	//TODO: Devolver objetos diferentes?
	/**
	 * Retorna los espacios disponibles donde que puede visitar el protagonista.
	 * Espacios del Pais Actual.
	 * No esta el Espacio Actual.
	 * @return
	 */
	public List<Espacio> obtenerEspaciosDisponiblesParaProtagonista(){
		List<Espacio> espacios = new ArrayList<Espacio>();
		Pais paisDelProtagonista = this.protagonista.getPaisActual();
		if(paisDelProtagonista != null)
			espacios.addAll(paisDelProtagonista.getEspacios()
											   .stream()
											   .filter(e -> e.getNombre() != this.protagonista.getEspacioActual().getNombre())
											   .collect(Collectors.toList()));
		return espacios;
	}
	
	//TODO: Devolver objetos diferentes?
	/**
	 * Retorna los paises disponibles donde puede viajar el protagonista.
	 * @return
	 */
	public List<Pais> obtenerPaisesDisponiblesParaProtagonista(){
		List<Pais> paises = new ArrayList<Pais>();
		paises.addAll(
				this.paises.values()
					.stream()
					.filter(p -> p.getNombre() != this.protagonista.getPaisActual().getNombre())
					.collect(Collectors.toList()));
		return paises;
	}

}
