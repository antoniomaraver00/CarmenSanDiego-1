package com.carmensandiego.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.pais.ClavePais;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.personajes.Antagonista;
import com.carmensandiego.model.personajes.Protagonista;
import com.carmensandiego.utils.PaisComparator;

/**
 * Representa todo el mundo contenido en la aplicacion.
 * @author mperez
 *
 */
public class Mundo {
	
	private static Mundo mundo;
	
	private Map<String,Pais> paises;
	private Protagonista protagonista;
	private Antagonista antagonista;
	
	private Mundo() {
		this.paises = new HashMap<String,Pais>();
		this.protagonista = new Protagonista();
		this.antagonista = new Antagonista();
	}
	
	public static  Mundo getSingletonInstance() {
		if (mundo == null)
			mundo = new Mundo();
		return mundo;
	}
	
	public Protagonista getProtagonista() {
		return this.protagonista;
	}
	
	public Pais getPais(String id) {
		return paises.get(id);
	}
	
	public void agregarPaises(Map<String,Pais> paises) {
		this.paises = paises;
	}

	public void crearProtagonista(String protagonista) {
		this.protagonista.setNombre(protagonista);
		this.protagonista.setDescripcion("El mejor detective de todos los tiempos");
	}
	
	public void crearAntagonista() {
		this.antagonista.viajar(this.getPais(ClavePais.CANADA.getKey()));
		this.antagonista.elegirRecorrido(paises);
	}
	
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
	
	/**
	 * Retorna todos los paises en el mundo ordenados alfabeticamente
	 * @return
	 */
	public List<Pais> obtenerPaisesOrdenadosAlfabeticamente(){
		return this.paises.values()
					.stream()
					.sorted(PaisComparator.alfabeticOrder())
					.collect(Collectors.toList());
	}

}
