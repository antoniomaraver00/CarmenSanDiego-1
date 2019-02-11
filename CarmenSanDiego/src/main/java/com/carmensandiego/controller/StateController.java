package com.carmensandiego.controller;

import com.carmensandiego.model.Mundo;

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
	
	private StateController() {
		this.mundo = Mundo.getSingletonInstance();
	}
	
	public static  StateController getSingletonInstance() {
		if (stateController == null)
			stateController = new StateController();
		return stateController;
	}
	
	public Mundo getMundo() {
		return mundo;
	}

}
