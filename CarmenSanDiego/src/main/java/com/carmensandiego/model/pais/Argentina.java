package com.carmensandiego.model.pais;

import com.carmensandiego.model.espacio.ClubNocturno;
import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.espacio.Home;
import com.carmensandiego.model.interfaz.ViajeroInterface;

public class Argentina extends Pais {
	
	public Argentina() {
		super("Argentina","Pais de Origen. Vivís aca.");
		Espacio home = new Home();
		this.espacios.add(home);
		Espacio clubNocturo = new ClubNocturno();
		this.espacios.add(clubNocturo);
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
