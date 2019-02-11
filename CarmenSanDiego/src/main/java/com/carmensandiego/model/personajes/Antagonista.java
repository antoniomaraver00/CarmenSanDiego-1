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

public class Antagonista extends Personaje implements ViajeroInterface{
	
	private Pais paisActual;
	
	private Espacio espacioActual;
	
	private PistasAcumuladas pistasAcumuladas;
	
	public Antagonista() {
		super();
		this.pistasAcumuladas = new PistasAcumuladas();
		this.paisActual = new NingunPais();
		this.espacioActual = new NingunEspacio();
	}

	@Override
	public void viajar(Viajable destino) {
		destino.antagonistaHaLlegado(pistasAcumuladas.tirarPistas());
		this.paisActual = destino.viajeroHaLlegado();
	}

	@Override
	public void visitar(Visitable destino) {
		destino.serVisitadoPorAntagonista(pistasAcumuladas.tirarPistas());
		this.espacioActual = destino.serVisitado();
	}
	
	@Deprecated
	public void setPista(Pista pista) {
		this.pistasAcumuladas.acumularPista(pista);
	}
	
	@Deprecated
	public List<Pista> obtenerPistas(){
		return this.pistasAcumuladas.getPistas();
	}
	
}
