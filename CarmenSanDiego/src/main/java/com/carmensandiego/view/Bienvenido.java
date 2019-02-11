package com.carmensandiego.view;

import com.carmensandiego.controller.StateController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bienvenido {
	
	private StateController stateController = null;
	
	public Bienvenido() {
		stateController = StateController.getSingletonInstance();
	}
	
	public void mostrarPantallaBienvenido(Stage primaryStage) {
		Text welcome = new Text("Bienvenido");
		Text name = new Text(stateController.getMundo().getProtagonista().getNombre());
		//Creating a Grid Pane 
		GridPane gridPane = new GridPane();    

		//Setting size for the pane 
		gridPane.setMinSize(500, 500);

		//Setting the padding  
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(5); 
		gridPane.setHgap(5);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.CENTER); 
		
		//Arranging all the nodes in the grid 
		gridPane.add(welcome, 0, 0); 
		gridPane.add(name, 1, 0); 

		//Styling nodes
		welcome.setStyle("-fx-font: normal bold 20px 'serif' "); 
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
	}

	
}
