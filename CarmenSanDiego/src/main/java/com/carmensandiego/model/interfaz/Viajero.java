package com.carmensandiego.model.interfaz;

import com.carmensandiego.model.lugar.Lugar;
import com.carmensandiego.model.pais.Pais;

public interface Viajero {
	
	/**
	 * Viajar a un destino
	 */
	public void viajar(Pais destino);
	
	/**
	 * Visitar un espacio
	 */
	public void visitar(Lugar destino);

}
