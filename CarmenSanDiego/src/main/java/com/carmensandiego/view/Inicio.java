package com.carmensandiego.view;

import com.carmensandiego.controller.HandlerController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Inicio {
	
	private HandlerController handlerController = null;
	
	public Inicio() {
		handlerController = HandlerController.getSingletonInstance();
	}
	
	public void mostrarPantallaInicio(Stage primaryStage) {
		//creating label nombre 
		Text name = new Text("Nombre");       

		//Creating Text Filed for nombre        
		TextField textFieldName = new TextField();       

		//Creating Buttons 
		Button enviar = new Button("Enviar"); 
		Button limpiar = new Button("Limpiar");  

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
		gridPane.add(name, 0, 0); 
		gridPane.add(textFieldName, 1, 0); 
		gridPane.add(enviar, 0, 2); 
		gridPane.add(limpiar, 1, 2); 

		//Styling nodes  
		enviar.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
		limpiar.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 

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
		handlerController.crearHandlerInicio(enviar, limpiar, textFieldName, primaryStage);
	}

}
