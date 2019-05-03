package com.carmensandiego.model.interfaz;

import java.util.List;

import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.pista.Pista;

public interface Viajable {
	/**
	 * Un viajero hay viajado a mi. Le doy mi ubicacion.
	 * @param viajero
	 */
	public Pais viajeroHaLlegado();
	
	/**
	 * El protagonista ha llegado y le doy mis pistas.
	 * @return
	 */
	public List<Pista> protagonistaHaLlegado();
	
	/**
	 * El antagonista ha llegado y tomo las pistas que dejó caer.
	 * @param pistas
	 */
	public void antagonistaHaLlegado(List<Pista> pistas);
	
	/**
	 * Ubica al viajero en mi primer lugar disponible.
	 */
	public void ubicarViajeroInicialmente(ViajeroInterface viajero);

}
