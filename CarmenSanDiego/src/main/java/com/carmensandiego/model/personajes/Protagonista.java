package com.carmensandiego.model.personajes;

import java.util.List;
import java.util.stream.Collectors;

import com.carmensandiego.model.interfaz.Viajero;
import com.carmensandiego.model.lugar.Lugar;
import com.carmensandiego.model.lugar.NingunEspacio;
import com.carmensandiego.model.pais.NingunPais;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public class Protagonista extends Personaje implements Viajero{
	
	private PistasAcumuladas pistasAcumuladas;
	
	private Pais paisActual;
	
	private Lugar espacioActual;
	
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

	public Lugar getEspacioActual() {
		return espacioActual;
	}
	
	public List<Pista> obtenerPistasAcumuladas() {
		return this.pistasAcumuladas.getPistas();
	}
	
	public List<Pista> obtenerPistasNoVistas(){
		return this.pistasAcumuladas.getPistas()
				.stream()
				.filter(p -> !p.getVisto())
				.collect(Collectors.toList());
	}

	/**
	 * El protagonista viaja a un viajable para buscar pistas.
	 * Actualiza su posicion.
	 * PRE:  Recibe un destino
	 * POST: Actualizo su Pais y su Espacio Actual.
	 */
	@Override
	public void viajar(Pais destino) {
		this.paisActual = destino;
		destino.ubicarViajeroInicialmente(this);
	}

	@Override
	public void visitar(Lugar destino) {
		this.pistasAcumuladas.acumularPistas(destino.serVisitadoPorProtagonista());
		this.espacioActual = destino.serVisitado();
	}
	
}
