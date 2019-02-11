package com.carmensandiego.model.personajes;

import java.util.List;

import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.espacio.NingunEspacio;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.interfaz.Visitable;
import com.carmensandiego.model.pais.NingunPais;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public class Protagonista extends Personaje implements ViajeroInterface{
	
	private PistasAcumuladas pistasAcumuladas;
	
	private Pais paisActual;
	
	private Espacio espacioActual;
	
	public Protagonista() {
		super();
		this.pistasAcumuladas = new PistasAcumuladas();
		this.paisActual = new NingunPais();
		this.espacioActual = new NingunEspacio();
	}

	@Override
	public void viajar(Viajable destino) {
		this.pistasAcumuladas.acumularPistas(destino.protagonistaHaLlegado());
		this.paisActual = destino.viajeroHaLlegado();
	}

	@Override
	public void visitar(Visitable destino) {
		this.pistasAcumuladas.acumularPistas(destino.serVisitadoPorProtagonista());
		this.espacioActual = destino.serVisitado();
	}
	
	@Deprecated
	public Pais enQuePaisEstoy() {
		return this.paisActual;
	}
	
	@Deprecated
	public Espacio enQueLugarEstoy() {
		return this.espacioActual;
	}
	
	@Deprecated
	public List<Pista> obtenerPistas() {
		return this.pistasAcumuladas.getPistas();
	}

}
