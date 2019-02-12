package com.carmensandiego.controller;

import java.util.List;

import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.view.BotonEspacio;

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
	
	/**
	 * Handler para la vista de Bienvenido.
	 * Mostrar introduccion.
	 * Empezar el juego.
	 * @param empezar
	 * @param primaryStage
	 */
	public void crearHandlerBienvenido(Button empezar, Stage primaryStage) {
		empezar.addEventFilter(MouseEvent.MOUSE_CLICKED, eventController.empezarEventHandler(primaryStage));
	}
	
	public void crearHandlerUbicacion(List<BotonEspacio> espacios, Stage primaryStage) {
		for (BotonEspacio botonEspacio : espacios) {
			Button boton = botonEspacio.getBoton();
			Espacio espacio = botonEspacio.getEspacio();
			boton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventController.protagonistaVisita(espacio, primaryStage));
		}
	}

}
