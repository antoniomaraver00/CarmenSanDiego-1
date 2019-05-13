package com.carmensandiego.model.personajes;

import java.util.ArrayList;
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
	
	/**
	 * Elige un recorrido por el mundo aleatoriamente.
	 * PRE: recibe el listado con todos los paises.
	 * POST: crea el recorrido aleatoriamente.
	 * 		 Si esta en un pais actual, no lo cuenta para el recorrido
	 */
	public void elegirRecorrido(List<Pais> paises) {
		//Agrego el listado de numeros posibles
		List<Integer> numerosPosibles = new ArrayList<Integer>();
		for (Pais pais : paises) {
			int i = 0;
			if(!this.paisActual.getNombre().equals(pais.getNombre()))
				numerosPosibles.add(i);
			i++;
		}
		int numerosGenerados = 0;
		int min=0;
        int max=(numerosPosibles.size());
		while(numerosGenerados != (paises.size()-1)) {
			//Numeros generados entre num1 y num2, sin decimales (incluyendo el num1 y el num2)
			int numAleatorio=(int)Math.floor(Math.random()*(min-(max+1))+(max));
			//Quito el numero posible indexado con ese numero. Que es el mismo numero que el indice.
			numerosPosibles.remove(numAleatorio);
			//Actualizo el maximo
			max=(numerosPosibles.size());
			//Agrego el pais indexado con ese numero.
			recorrido.agregarDestino(paises.get(numAleatorio));
		}
	}
	
	/**
	 * Sigue el recorrido elegido.
	 * Viaja al proximo destino
	 * Registra el destino donde ha viajado
	 * PRE: Listado de destinos no vacio
	 * POST: Listado de registros no vacio
	 */
	public void seguirRecorrido() {
		this.viajar(recorrido.obtenerProximoDestino());
		this.recorrido.registrarUltimoDestino();
	}
	
}
