package com.carmensandiego.app;

import com.carmensandiego.controller.InitController;
import com.carmensandiego.view.Inicio;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Esta clase es la responsable de iniciar la Aplicacion.
 * Muere cuando termina la aplicacion.
 * @author martin
 *
 */
public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		InitController initController = InitController.getSingletonInstance();
		initController.crearMundo();
		
		Inicio inicio = new Inicio();
		inicio.mostrarPantallaInicio(primaryStage);
	}
	
	/**
	 * Este metodo solo es util para que eclipse ejecute la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
    }

}