package com.carmensandiego.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controllador encargado de atender las interrupciones de los usuarios del juego, 
 * como el ingreso por teclado de acciones, respuesta a preguntas, decisiones de juego, etc.
 * @author martin
 *
 */
public class HandlerController {
	
	private static HandlerController handlerController = null;
	private EventController eventController = null;
	
	private HandlerController() {
		this.eventController = EventController.getSingletonInstance();
	}
	
	public static  HandlerController getSingletonInstance() {
		if (handlerController == null)
			handlerController = new HandlerController();
		return handlerController;
	}
	
	/**
	 * Handler para la vista de Inicio.
	 * Enviar el nombre del jugador.
	 * Limpiar el input del nombre del jugador.
	 * @param enviar
	 * @param limpiar
	 * @param textFieldName
	 * @param primaryStage
	 */
	public void crearHandlerInicio(Button enviar, Button limpiar, TextField textFieldName, Stage primaryStage) {
		//Registering the event filter 
		enviar.addEventFilter(MouseEvent.MOUSE_CLICKED, eventController.enviarNombreJugadorEventHandler(textFieldName, primaryStage));   
		limpiar.addEventFilter(MouseEvent.MOUSE_CLICKED, eventController.limpiarNombreJugadorEventHandler(textFieldName, primaryStage)); 
	}

}
