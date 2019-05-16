package com.carmensandiego.view;

import com.carmensandiego.model.lugar.Lugar;

import javafx.scene.control.Button;

public class BotonEspacio {
	
	private Button boton;
	private Lugar espacio;
	
	public BotonEspacio(Lugar espacio) {
		this.espacio = espacio;
		boton = new Button(espacio.getNombre());
	}

	public Button getBoton() {
		return boton;
	}

	public Lugar getEspacio() {
		return espacio;
	}
	
}
