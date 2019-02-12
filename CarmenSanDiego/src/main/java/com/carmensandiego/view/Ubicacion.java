package com.carmensandiego.view;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.controller.HandlerController;
import com.carmensandiego.controller.StateController;
import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.espacio.Espacio;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ubicacion {
	
	private StateController stateController = null;
	private HandlerController handlerController = null;
	
	public Ubicacion() {
		stateController = StateController.getSingletonInstance();
		handlerController = HandlerController.getSingletonInstance();
	}
	
	public void mostrarPantallaUbicacion(Stage primaryStage) {
		
		Mundo mundo = stateController.getMundo();
		
		Text country = new Text("Pais Actual: "+ mundo.getProtagonista().getPaisActual().getNombre());
		Text space = new Text("Lugar Actual: "+ mundo.getProtagonista().getEspacioActual().getNombre());
		Text message = new Text("Descripcion: "+ mundo.getProtagonista().getEspacioActual().getDescripcion());
		
		List<BotonEspacio> espacios = new ArrayList<BotonEspacio>();
		for(Espacio espacio : mundo.obtenerEspaciosDisponiblesParaProtagonista()) {
			espacios.add(new BotonEspacio(espacio));
		}
		
		//Creating a Grid Pane 
		GridPane gridPane = new GridPane();    

		//Setting size for the pane 
		gridPane.setMinSize(1500, 1500);

		//Setting the padding  
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.CENTER); 
		
		//Arranging all the nodes in the grid 
		gridPane.add(country, 0, 0); 
		gridPane.add(space, 0, 1); 
		gridPane.add(message, 0, 2);
		for (BotonEspacio botonEspacio : espacios) {
			int i = 3;
			int j = 0;
			gridPane.add(botonEspacio.getBoton(), j, i);
			j++;
		}
		
		//Styling nodes
		country.setStyle("-fx-font: normal bold 30px 'serif' "); 
		space.setStyle("-fx-font: normal bold 30px 'serif' "); 
		message.setStyle("-fx-font: normal bold 20px 'serif' ");
		gridPane.setStyle("-fx-background-color: BEIGE;"); 

		// Creating a scene object 
		Scene scene = new Scene(gridPane); 

		// Adding scene to the stage 
		primaryStage.setScene(scene);

		//Displaying the contents of the stage 
		primaryStage.show();
		
		//Handlers y Eventos de la pantalla de Ubicacion
		handlerController.crearHandlerUbicacion(espacios, primaryStage);
	}
	
}
