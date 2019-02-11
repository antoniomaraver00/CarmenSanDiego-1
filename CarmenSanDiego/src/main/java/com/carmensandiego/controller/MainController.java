package com.carmensandiego.controller;

import com.carmensandiego.view.Inicio;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Esta clase es la responsable de iniciar la Aplicacion.
 * Muere cuando termina la aplicacion.
 * @author martin
 *
 */
public class MainController extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		InitController initController = InitController.getSingletonInstance();
		initController.crearMundo();
		initController = null;
		
		Inicio inicio = new Inicio();
		inicio.mostrarPantallaInicio(primaryStage);
		inicio = null;
	}
	
	/**
	 * Este metodo solo es util para que eclipse ejecute la aplicacion
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
    }

}