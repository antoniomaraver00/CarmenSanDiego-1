package com.carmensandiego.view;

import java.util.ArrayList;
import java.util.List;

import com.carmensandiego.controller.HandlerController;
import com.carmensandiego.controller.StateController;
import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.lugar.Lugar;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.parametria.ParametriaVista;
import com.carmensandiego.model.pista.Pista;

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
		
		Text time = new Text("Tiempo Restante: "+stateController.obtenerTiempoRestante());
		
		List<BotonEspacio> espacios = new ArrayList<BotonEspacio>();
		for(Lugar espacio : mundo.obtenerEspaciosDisponiblesParaProtagonista()) {
			espacios.add(new BotonEspacio(espacio));
		}
		
		List<BotonPais> paises = new ArrayList<BotonPais>();
		for (Pais pais : mundo.obtenerPaisesDisponiblesParaProtagonista()) {
			paises.add(new BotonPais(pais));
		}
		
		List<Text> pistas = new ArrayList<Text>();
		for (Pista pista : mundo.getProtagonista().obtenerPistasNoVistas()) {
			pista.verPista();
			Text textPista = new Text(pista.getMensaje());
			pistas.add(textPista);
		}
		
		//Creating a Grid Pane 
		GridPane gridPane = new GridPane();    

		//Setting size for the pane 
		gridPane.setMinSize(ParametriaVista.WIDTH.getValue(), ParametriaVista.HEIGHT.getValue());

		//Setting the padding  
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(10); 
		gridPane.setHgap(10);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.CENTER); 
		
		//Arranging all the nodes in the grid 
		gridPane.add(time, 5, 1);
		gridPane.add(country, 0, 2); 
		gridPane.add(space, 0, 3); 
		gridPane.add(message, 0, 4);
		int i = 5;
		int j = 0;
		for (BotonEspacio botonEspacio : espacios) {
			gridPane.add(botonEspacio.getBoton(), j, i);
			j++;
		}
		i = 6;
		j = 0;
		for (BotonPais botonPais : paises) {
			gridPane.add(botonPais.getBoton(), j, i);
			j++;
		}
		i = 7;
		j = 0;
		for (Text text : pistas) {
			gridPane.add(text, j, i);
			text.setStyle("-fx-font: normal bold 20px 'serif' ");
			i++;
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
		handlerController.crearHandlerUbicacion(espacios, paises, primaryStage);
	}
	
}
