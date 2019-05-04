package com.carmensandiego.view;

import com.carmensandiego.controller.HandlerController;
import com.carmensandiego.controller.StateController;
import com.carmensandiego.model.parametria.ParametriaVista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Fin {

	private HandlerController handlerController = null;
	private StateController stateController = null;
	
	public Fin() {
		handlerController = HandlerController.getSingletonInstance();
		stateController = StateController.getSingletonInstance();
	}
	
	public void mostrarPantallaFin(Stage primaryStage) {
		//Creating labels
		Text name = new Text(stateController.getMundo().getProtagonista().getNombre());   
		Text message = new Text("El juego ha terminado.\n Gracias por jugar!!");
		Button salir = new Button("Salir"); 
		
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
		gridPane.add(name, 1, 0); 
		gridPane.add(message, 0, 1);
		gridPane.add(salir, 0,2);
	
		//Styling nodes  
		salir.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
	
		name.setStyle("-fx-font: normal bold 20px 'serif' "); 
		gridPane.setStyle("-fx-background-color: BEIGE;"); 
	
		// Creating a scene object 
		Scene scene = new Scene(gridPane); 
	
		// Setting title to the Stage   
		primaryStage.setTitle("Carmen san diego"); 
	
		// Adding scene to the stage 
		primaryStage.setScene(scene);
	
		//Displaying the contents of the stage 
		primaryStage.show();
		
		//Handlers y Eventos de la pantalla de Inicio
		handlerController.crearHandlerFin(salir, primaryStage);
	}
	
}
