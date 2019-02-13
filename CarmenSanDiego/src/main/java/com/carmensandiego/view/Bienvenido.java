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

public class Bienvenido {
	
	private StateController stateController = null;
	private HandlerController handlerController = null;
	
	public Bienvenido() {
		stateController = StateController.getSingletonInstance();
		handlerController = HandlerController.getSingletonInstance();
	}
	
	public void mostrarPantallaBienvenido(Stage primaryStage) {
		Text welcome = new Text("Bienvenido");
		Text name = new Text(stateController.getMundo().getProtagonista().getNombre());
		Text message = new Text("Eres el ayudante y sucesor del detective mas importante de nuestros tiempos, Wincho.\n"
				+ "Por desgracia, el ha desaparecido en su busqueda por la Maravilla Nacional de Monterreal.\n"
				+ "Aparentemente un criminal de sexo femenino ha sido visto en el lugar del crimen.\n"
				+ "Lleva mas de una semana en fuga y Wincho la ha perseguido sin parar, pero con resultados fallidos.\n"
				+ "Tu mision es encontrarla a ella y a tu mentor antes del Domingo a las 17hs o el tesoro se perderá por siempre y habra un conflicto internacional.\n"
				+ "Hemos recuperado el ultimo BackUp de pistas que Wincho recolectó. Esperemos que te sea de ayuda para empezar tu camino. Buena suerte!");
		Button empezar = new Button("Empezar"); 
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
		gridPane.add(welcome, 0, 0); 
		gridPane.add(name, 1, 0); 
		gridPane.add(message, 0, 1);
		gridPane.add(empezar, 0,2);
		
		//Styling nodes
		welcome.setStyle("-fx-font: normal bold 30px 'serif' "); 
		name.setStyle("-fx-font: normal bold 30px 'serif' "); 
		message.setStyle("-fx-font: normal bold 20px 'serif' ");
		empezar.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
		gridPane.setStyle("-fx-background-color: BEIGE;"); 

		// Creating a scene object 
		Scene scene = new Scene(gridPane); 

		// Adding scene to the stage 
		primaryStage.setScene(scene);

		//Displaying the contents of the stage 
		primaryStage.show();
		
		//Handlers y Eventos de la pantalla de Bienvenido
		handlerController.crearHandlerBienvenido(empezar, primaryStage);
	}

	
}
