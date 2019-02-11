package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.Embajada;
import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.interfaz.ViajeroInterface;

public class Rusia extends Pais {
	
	public Rusia() {
		super("Rusia","Un lugar frio, con muchos monumentos exoticos y tesoros antiguos");
		Espacio embajada = new Embajada();
		this.espacios.add(embajada);
	}

	@Override
	public void viajeroHaLlegado(ViajeroInterface viajero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viajeroSeHaIdo(ViajeroInterface viajero) {
		// TODO Auto-generated method stub
		
	}

}
