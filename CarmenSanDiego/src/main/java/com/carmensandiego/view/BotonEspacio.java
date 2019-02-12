package com.carmensandiego.view;

import com.carmensandiego.model.espacio.Espacio;

import javafx.scene.control.Button;

public class BotonEspacio {
	
	private Button boton;
	private Espacio espacio;
	
	public BotonEspacio(Espacio espacio) {
		this.espacio = espacio;
		boton = new Button(espacio.getNombre());
	}

	public Button getBoton() {
		return boton;
	}

	public Espacio getEspacio() {
		return espacio;
	}
	
}
