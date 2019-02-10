package com.carmensandiego.model.interfaz;

import java.util.List;

import com.carmensandiego.model.pista.Pista;

public interface Viajable {
	/**
	 * Un viajero hay viajado a mi
	 * @param viajero
	 */
	public void viajeroHaLlegado(ViajeroInterface viajero);
	
	/**
	 * Un viajero se ha ido de mi
	 * @param viajero
	 */
	public void viajeroSeHaIdo(ViajeroInterface viajero);
	
	
	/**
	 * El protagonista viajo y le doy mis pistas
	 * @return
	 */
	public List<Pista> protagonistaHaLlegado();
	
	/**
	 * El antagonista viajo y tomo las pistas que dejo caer
	 * @param pistas
	 */
	public void antagonistaHaLlegado(List<Pista> pistas);

}
