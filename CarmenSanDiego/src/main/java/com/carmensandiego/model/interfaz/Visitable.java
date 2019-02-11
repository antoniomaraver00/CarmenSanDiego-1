package com.carmensandiego.model.interfaz;

import java.util.List;

import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.pista.Pista;

public interface Visitable {
	
	/**
	 * Ser visitado por un viajero. Le doy mi ubicacion.
	 */
	public Espacio serVisitado();
	
	/**
	 * Ser visitado por el Protagonista. Le doy mis pistas.
	 * @return pistas que encuentra en la visita
	 */
	public List<Pista> serVisitadoPorProtagonista();
	
	/**
	 * Ser visitado por el antagonista. Tomo sus pistas.
	 * @param pistasDelAntagonista que deja en su viaje
	 */
	public void serVisitadoPorAntagonista(List<Pista> pistasDelAntagonista);

}
