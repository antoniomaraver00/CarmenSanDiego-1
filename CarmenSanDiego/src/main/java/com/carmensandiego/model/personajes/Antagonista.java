package com.carmensandiego.model.personajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.espacio.NingunEspacio;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.interfaz.Visitable;
import com.carmensandiego.model.pais.NingunPais;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;
import com.carmensandiego.model.recorrido.Recorrido;

public class Antagonista extends Personaje implements ViajeroInterface{
	
	private Pais paisActual;
	
	private Espacio espacioActual;
	
	private PistasAcumuladas pistasAcumuladas;
	
	private Recorrido recorrido;
	
	public Antagonista() {
		super();
		this.pistasAcumuladas = new PistasAcumuladas();
		this.paisActual = new NingunPais();
		this.espacioActual = new NingunEspacio();
		this.recorrido = new Recorrido();
	}
	
	public Pais getPaisActual() {
		return paisActual;
	}

	public Espacio getEspacioActual() {
		return espacioActual;
	}
	
	public void acumularPista(Pista pista) {
		this.pistasAcumuladas.acumularPista(pista);
	}
	
	public List<Pista> tirarPistas(){
		return this.pistasAcumuladas.tirarPistas();
	}

	@Override
	public void viajar(Viajable destino) {
		destino.antagonistaHaLlegado(pistasAcumuladas.tirarPistas());
		this.paisActual = destino.viajeroHaLlegado();
		destino.ubicarViajeroInicialmente(this);
	}

	@Override
	public void visitar(Visitable destino) {
		destino.serVisitadoPorAntagonista(pistasAcumuladas.tirarPistas());
		this.espacioActual = destino.serVisitado();
	}
	
	/**
	 * Elige un recorrido por el mundo aleatoriamente.
	 * PRE: recibe el listado con todos los paises.
	 * 		El antagonista debe estar en un Pais Actual.
	 * 		El Pais Actual existe y esta en el listado de todos los paises.
	 * POST: crea el recorrido aleatoriamente.
	 * 		 No cuenta el Pais Actual para el recorrido.
	 */
	public void elegirRecorrido(Map<String, Pais> mapaPaises) {
		List<Pais> paises = mapaPaises.values()
									  .stream()
									  .collect(Collectors.toList());
		//Creo un listado de numeros posibles
		List<Integer> numerosPosibles = new ArrayList<Integer>();
		int numerosTotales = 0;
		//Para cada pais creo un indice que sera agregado como numero posible si el pais no es el actual.
		for (Pais pais : paises) {
			if(!this.paisActual.getNombre().equals(pais.getNombre()))
				numerosPosibles.add(numerosTotales);
			numerosTotales++;
		}
		int numerosGenerados = 0;
		int min=0;
		//El maximo indice de los numeros posibles es la cantidad de numeros posibles menos 1.
		Integer max=(numerosPosibles.size() -1);
		//Solo existe un indice de pais que no sera agregado al listado de numeros posibles.
		while(numerosGenerados < numerosTotales - 1) {
			//Numeros generados entre min y max, sin decimales (incluyendo el min y el max)
			int numAleatorio=(int)Math.floor(Math.random()*(max - min));
			//Recupero y quito el numero posible (indice de pais) indexado con el numero aleatorio.
			int indexPais = numerosPosibles.remove(numAleatorio);
			//Actualizo el maximo.
			max=(numerosPosibles.size() -1);
			//Agrego el pais indexado con el numero indexado por el numero aleatorio.
			recorrido.agregarDestino(paises.get(indexPais));
			numerosGenerados++;
		}
	}
	
	/**
	 * Sigue el recorrido elegido.
	 * Genera las pistas del proximo destino para el protagonista.
	 * Viaja al proximo destino.
	 * Registra el destino donde ha viajado.
	 * PRE: Listado de destinos no vacio
	 * POST: Listado de registros no vacio
	 */
	public void seguirRecorrido() {
		this.viajar(recorrido.obtenerProximoDestino());
		this.recorrido.registrarUltimoDestino();
	}
	
	/**
	 * Retorna el proximo destino del Antagonista.
	 * @return
	 */
	public Pais obtenerProximoDestino() {
		return this.recorrido.obtenerProximoDestino();
	}
	
}
