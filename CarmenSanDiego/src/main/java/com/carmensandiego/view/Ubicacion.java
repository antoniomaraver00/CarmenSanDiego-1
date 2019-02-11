package com.carmensandiego.view;

import com.carmensandiego.controller.StateController;
import com.carmensandiego.model.Mundo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ubicacion {
	
	private StateController stateController = null;
	
	public Ubicacion() {
		stateController = StateController.getSingletonInstance();
	}
	
	public void mostrarPantallaUbicacionInicial(Stage primaryStage) {
		
		Mundo mundo = stateController.getMundo();
		
		Text country = new Text("Pais Actual: "+ mundo.getProtagonista().enQuePaisEstoy().getNombre());
		Text space = new Text("Lugar Actual: "+ mundo.getProtagonista().enQueLugarEstoy().getNombre());
		Text message = new Text("Descripcion: "+ mundo.getProtagonista().enQueLugarEstoy().getDescripcion());
		
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
	}
	
	public void mostrarPantallaUbicacion(Stage primaryStage) {
		Text country = new Text("Pais Actual: ");
		Text space = new Text("Lugar Actual: ");
		Text message = new Text("Descripcion: ");
		Button empezar = new Button("Empezar"); 
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
		gridPane.add(space, 1, 0); 
		gridPane.add(message, 0, 1);
		gridPane.add(empezar, 0,2);
		
		//Styling nodes
		country.setStyle("-fx-font: normal bold 30px 'serif' "); 
		space.setStyle("-fx-font: normal bold 30px 'serif' "); 
		message.setStyle("-fx-font: normal bold 20px 'serif' ");
		empezar.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
		gridPane.setStyle("-fx-background-color: BEIGE;"); 

		// Creating a scene object 
		Scene scene = new Scene(gridPane); 

		// Adding scene to the stage 
		primaryStage.setScene(scene);

		//Displaying the contents of the stage 
		primaryStage.show();
	}

}
