package com.carmensandiego.model.personajes;

import java.util.List;

import com.carmensandiego.model.espacio.NingunEspacio;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.interfaz.Visitable;
import com.carmensandiego.model.pais.NingunPais;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public class Protagonista extends Personaje implements ViajeroInterface{
	
	private PistasAcumuladas pistasAcumuladas;
	
	private Viajable paisActual;
	
	private Visitable espacioActual;
	
	public Protagonista() {
		super();
		this.pistasAcumuladas = new PistasAcumuladas();
		this.paisActual = new NingunPais();
		this.espacioActual = new NingunEspacio();
	}

	@Override
	public void viajar(Viajable destino) {
		this.paisActual.viajeroSeHaIdo(null);;
		this.pistasAcumuladas.acumularPistas(destino.protagonistaHaLlegado());
		this.paisActual = destino;
	}

	@Override
	public void visitar(Visitable destino) {
		this.espacioActual.despedirVisita();
		this.pistasAcumuladas.acumularPistas(destino.serVisitadoPorProtagonista());
		this.espacioActual = destino;
	}
	
	@Deprecated
	public Viajable enQuePaisEstoy() {
		return this.paisActual;
	}
	
	@Deprecated
	public Visitable enQueLugarEstoy() {
		return this.espacioActual;
	}
	
	@Deprecated
	public List<Pista> obtenerPistas() {
		return this.pistasAcumuladas.getPistas();
	}

}
