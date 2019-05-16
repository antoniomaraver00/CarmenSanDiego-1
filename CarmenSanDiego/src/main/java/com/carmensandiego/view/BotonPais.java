package com.carmensandiego.view;

import com.carmensandiego.model.pais.Pais;

import javafx.scene.control.Button;

public class BotonPais {
	
	private Button boton;
	private Pais pais;
	
	public BotonPais(Pais pais) {
		this.boton = new Button(pais.getNombre());
		this.pais = pais;
	}

	public Button getBoton() {
		return boton;
	}

	public Pais getPais() {
		return pais;
	}
	
}
