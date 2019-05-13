package com.carmensandiego.model.recorrido;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.exception.SinProximosDestinosException;
import com.carmensandiego.model.pais.Pais;

/**
 * Esta clase representa el Recorrido de los personajes.
 * Es responsable de marcar los paises que seran visitados en el futuro.
 * @author mperez
 *
 */
public class Recorrido {
	
	private List<Pais> destinos;
	private List<Pais> visitados;
	
	public Recorrido() {
		this.destinos =  new ArrayList<Pais>();
		this.visitados = new ArrayList<Pais>();
	}
	
	public Recorrido(List<Pais> destinos) {
		this.destinos = new ArrayList<Pais>(destinos);
		this.visitados = new ArrayList<Pais>();
	}

	public List<Pais> getDestinos() {
		return destinos;
	}
	
	public List<Pais> getVisitados(){
		return visitados;
	}
	
	/**
	 * Devuelve el proximo pais que sera visitado
	 * @return
	 */
	public Pais obtenerProximoDestino() {
		if (this.destinos.isEmpty())
			throw new SinProximosDestinosException();
		return this.destinos.get(0);
	}
	
	/**
	 * Agrega un proximo destino al final del recorrido.
	 * @param destino
	 */
	public void agregarDestino(Pais destino) {
		this.destinos.add(destino);
	}
	
	/**
	 * Registra que ha sido visitado el ultimo destino.
	 * PRE: Viajar al pais marcado como Proximo Destino del Recorrido.
	 * POST: El pais donde se ha viajado queda tachado de la lista de destinos.
	 * @param destino
	 */
	public void registrarUltimoDestino() {
		if (this.destinos.isEmpty())
			throw new SinProximosDestinosException();
		this.visitados.add(this.destinos.remove(0));
	}

}
