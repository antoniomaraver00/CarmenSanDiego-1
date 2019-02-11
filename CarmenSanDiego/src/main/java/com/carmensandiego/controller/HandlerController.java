package com.carmensandiego.controller;

import com.carmensandiego.model.Mundo;

/**
 * Controllador encargado de atender las interrupciones de los usuarios del juego, 
 * como el ingreso por teclado de acciones, respuesta a preguntas, decisiones de juego, etc.
 * @author martin
 *
 */
public class HandlerController {
	
	private Mundo mundo = null;
	
	public HandlerController() {
		this.mundo = Mundo.getSingletonInstance();
	}

}
