package com.carmensandiego.model.personajes;

import java.util.List;

import com.carmensandiego.model.espacio.NingunEspacio;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.interfaz.Visitable;
import com.carmensandiego.model.pais.NingunPais;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public class Antagonista extends Personaje implements ViajeroInterface{
	
	private Viajable paisActual;
	
	private Visitable espacioActual;
	
	private PistasAcumuladas pistasAcumuladas;
	
	public Antagonista() {
		super();
		this.pistasAcumuladas = new PistasAcumuladas();
		this.paisActual = new NingunPais();
		this.espacioActual = new NingunEspacio();
	}

	@Override
	public void viajar(Viajable destino) {
		this.paisActual.viajeroSeHaIdo(null);;
		destino.antagonistaHaLlegado(pistasAcumuladas.tirarPistas());
		this.paisActual = destino;
	}

	@Override
	public void visitar(Visitable destino) {
		this.espacioActual.despedirVisita();
		destino.serVisitadoPorAntagonista(pistasAcumuladas.tirarPistas());
		this.espacioActual = destino;
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
