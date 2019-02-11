package com.carmensandiego.controller;

import com.carmensandiego.model.Mundo;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Esta clase es la encargada de manejar y controlar los eventos que ocurren en el mundo.
 * Para cada evento ocurrido debe ser la responsable de cambiar los estados de los personajes,
 * jugadores y objetos del juego.
 * Pide al InitController el mundo creado
 * @author martin
 *
 */
public class EventController {
	
	private static EventController eventController = null;
	private Mundo mundo = null;
	
	private EventController() {
		this.mundo = Mundo.getSingletonInstance();
	}
	
	public static  EventController getSingletonInstance() {
		if (eventController == null)
			eventController = new EventController();
		return eventController;
	}
	
	//Creating the mouse event handler 
	public EventHandler<MouseEvent> enviarNombreJugadorEventHandler(TextField textFieldName, Stage primaryStage){
		EventHandler<MouseEvent> botonEnviarEventHandler = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				mundo.crearProtagonista(textFieldName.getText());
				primaryStage.hide();
			} 
		};
		return botonEnviarEventHandler;
	}
	
	//Creating the mouse event handler 
	public EventHandler<MouseEvent> limpiarNombreJugadorEventHandler(TextField textFieldName, Stage primaryStage){
		EventHandler<MouseEvent> botonLimpiarEventHandler = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				textFieldName.setText("");
			} 
		}; 
		return botonLimpiarEventHandler;
	}
}
