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
	
	public PistasAcumuladas getPistasAcumuladas() {
		return pistasAcumuladas;
	}

	public Pais getPaisActual() {
		return paisActual;
	}

	public Espacio getEspacioActual() {
		return espacioActual;
	}
	
	public List<Pista> obtenerPistasAcumuladas() {
		return this.pistasAcumuladas.getPistas();
	}

	@Override
	public void viajar(Viajable destino) {
		this.pistasAcumuladas.acumularPistas(destino.protagonistaHaLlegado());
		this.paisActual = destino.viajeroHaLlegado();
		destino.ubicarViajeroInicialmente(this);
	}

	@Override
	public void visitar(Visitable destino) {
		this.pistasAcumuladas.acumularPistas(destino.serVisitadoPorProtagonista());
		this.espacioActual = destino.serVisitado();
	}
	
}
