package com.carmensandiego.controller;

import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.parametria.ParametriaTime;
import com.carmensandiego.view.Bienvenido;
import com.carmensandiego.view.Fin;
import com.carmensandiego.view.Ubicacion;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Esta clase es la encargada de manejar y controlar los eventos que ocurren en el mundo.
 * Para cada evento ocurrido debe ser la responsable de cambiar los estados de los personajes,
 * jugadores, objetos del juego y vistas.
 * @author martin
 *
 */
public class EventController {
	
	private static EventController eventController = null;
	private StateController stateController = null;
	private Mundo mundo = null;
	
	private EventController() {
		this.stateController = StateController.getSingletonInstance();
		this.mundo = Mundo.getSingletonInstance();
	}
	
	public static  EventController getSingletonInstance() {
		if (eventController == null)
			eventController = new EventController();
		return eventController;
	}
	
	//Creating the mouse event
	public EventHandler<MouseEvent> enviarNombreJugadorEventHandler(TextField textFieldName, Stage primaryStage){
		EventHandler<MouseEvent> botonEnviarEventHandler = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				mundo.crearProtagonista(textFieldName.getText());
				Bienvenido bienvenido = new Bienvenido();
				bienvenido.mostrarPantallaBienvenido(primaryStage);
				bienvenido = null;
			} 
		};
		return botonEnviarEventHandler;
	}
	
	//Creating the mouse event 
	public EventHandler<MouseEvent> limpiarNombreJugadorEventHandler(TextField textFieldName, Stage primaryStage){
		EventHandler<MouseEvent> botonLimpiarEventHandler = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				textFieldName.setText("");
			} 
		}; 
		return botonLimpiarEventHandler;
	}
	
	//Creating the mouse event
	public EventHandler<MouseEvent> empezarEventHandler(Stage primaryStage) {
		EventHandler<MouseEvent> botonEmpezarEventHandler = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) {
				ViajeroInterface viajero = mundo.getProtagonista();
				viajero.viajar(mundo.getPais("ARGENTINA"));
				//TODO: Otra manera de setearlo en la casa.
				viajero.visitar(mundo.getPais("ARGENTINA").getEspacios().get(1));
				Ubicacion ubicacion = new Ubicacion();
				ubicacion.mostrarPantallaUbicacion(primaryStage);
				ubicacion = null;
			} 
		}; 
		return botonEmpezarEventHandler;
	}

	//Creating the mouse event
	public EventHandler<MouseEvent> protagonistaVisita(Espacio espacio, Stage primaryStage) {
		EventHandler<MouseEvent> botonVisitarEventHandler = new EventHandler<MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) {
				ViajeroInterface viajero = mundo.getProtagonista();
				viajero.visitar(espacio);
				stateController.avanzarTiempo(ParametriaTime.VISIT_TIME.getValue());
				if(stateController.finDeJuego()){
					Fin fin = new Fin();
					fin.mostrarPantallaFin(primaryStage);
					fin = null;
				}else {
					Ubicacion ubicacion = new Ubicacion();
					ubicacion.mostrarPantallaUbicacion(primaryStage);
					ubicacion = null;
				}
			} 
		}; 
		return botonVisitarEventHandler;
	}
	
	//Creating the mouse event
	public EventHandler<MouseEvent> protagonistaViaja(Pais pais, Stage primaryStage) {
		EventHandler<MouseEvent> botonViajarEventHandler = new EventHandler<MouseEvent>() {
			@Override 
			public void handle(MouseEvent e) {
				ViajeroInterface viajero = mundo.getProtagonista();
				viajero.viajar(pais);
				stateController.avanzarTiempo(ParametriaTime.TRAVEL_TIME.getValue());
				if(stateController.finDeJuego()){
					Fin fin = new Fin();
					fin.mostrarPantallaFin(primaryStage);
					fin = null;
				}else {
					Ubicacion ubicacion = new Ubicacion();
					ubicacion.mostrarPantallaUbicacion(primaryStage);
					ubicacion = null;
				}
			} 
		};
		return botonViajarEventHandler;
	}

	//Creating the mouse event
	public EventHandler<MouseEvent> terminarJuego(Stage primaryStage) {
		EventHandler<MouseEvent> botonSalirEventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				primaryStage.close();
			}
		};
		return botonSalirEventHandler;
	}
}
