package com.carmensandiego.controller;

import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.Timer;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.personajes.Antagonista;

/**
 * Esta clase se encarga de chequear los estados del juego.
 * Actualiza cada vez que hay un cambio y chequea las condiciones para eventos importantes.
 * Muestra a las vistas el estado actual del mundo y del juego
 * Por ejemplo: Finalizar el juego.
 * @author martin
 *
 */
public class StateController {
	
	private static StateController stateController = null;
	private Mundo mundo = null;
	private Timer timer = null;
	private Antagonista antagonista = null;
	
	private StateController() {
		this.mundo = Mundo.getSingletonInstance();
		this.timer = Timer.getSingletonInstance();
		this.antagonista = mundo.getAntagonista();
	}
	
	public static StateController getSingletonInstance() {
		if (stateController == null)
			stateController = new StateController();
		return stateController;
	}
	
	public Mundo getMundo() {
		return mundo;
	}
	
	/**
	 * El antagonista se mueve para no ser atrapado por el protagonista
	 * Dada su audacia, sabe cual sera el destino del protagonista.
	 * @param destinoProtagonista
	 */
	public void moverAntagonista(Viajable destinoProtagonista) {
		this.antagonista.seguirRecorrido(destinoProtagonista);
	}
	
	/**
	 * Avanza el tiempo en el mundo del juego
	 * Recibe la cantidad de tiempo a avanzar en horas.
	 * @param hours
	 */
	public void avanzarTiempo(Long hours) {
		this.timer.descontarTiempo(hours);
	}
	
	/**
	 * Chequea y regresa si el juego ha terminado
	 * @return
	 */
	public Boolean finDeJuego() {
		return this.timer.tiempoAgotado();
	}
	
	public String obtenerTiempoRestante(){
		return this.timer.getTiempoRestante();
	}

}
