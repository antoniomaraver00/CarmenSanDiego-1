package com.carmensandiego.model.interfaz;

import java.util.List;

import com.carmensandiego.model.pista.Pista;

public interface Visitable {
	
	/**
	 * Ser visitado por un viajero
	 */
	public void serVisitado(ViajeroInterface viajero);
	
	/**
	 * Despedir a un viajero de su visita
	 */
	public void despedirVisita();
	
	/**
	 * Ser visitado por el Protagonista
	 * @return pistas que encuentra en la visita
	 */
	public List<Pista> serVisitadoPorProtagonista();
	
	/**
	 * Ser visitado por el antagonista
	 * @param pistasDelAntagonista que deja en su viaje
	 */
	public void serVisitadoPorAntagonista(List<Pista> pistasDelAntagonista);

}
