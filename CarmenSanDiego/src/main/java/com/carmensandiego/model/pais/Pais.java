package com.carmensandiego.model.pais;

import java.util.List;

import com.carmensandiego.alerta.Alerta;
import com.carmensandiego.model.interfaz.Viajero;
import com.carmensandiego.model.lugar.Aeropuerto;
import com.carmensandiego.model.lugar.Lugar;
import com.carmensandiego.model.lugar.Lugares;
import com.carmensandiego.model.pista.Pista;
import com.carmensandiego.model.pista.PistasAcumuladas;

public abstract class Pais {
	
	protected String nombre;
	
	protected String descripcion;
	
	protected String capital;
	
	protected Lugares lugares;
	
	protected PistasAcumuladas pistasAcumuladas;
	
	protected Alerta alerta;
	
	public Pais() {
		this.nombre = "";
		this.descripcion = "";
		this.lugares = new Lugares();
		this.pistasAcumuladas = new PistasAcumuladas();
		this.acumularPistas(this.crearMisPistas());
	}
	
	public Pais(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lugares = new Lugares();
		this.pistasAcumuladas = new PistasAcumuladas();
		this.lugares.agregarLugar(new Aeropuerto(this.nombre));
		this.acumularPistas(this.crearMisPistas());
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public List<Lugar> getLugares() {
		return lugares.getLugares();
	}

	public void agregarLugar(Lugar lugar) {
		lugares.agregarLugar(lugar);
	}
	
	/**
	 * El pais acumula las pistas que recibe.
	 * Las distribuye a sus lugares para que los personajes secundarios sean los informantes
	 * PRE: No tiene
	 * POST: Las pistas acumuladas se dan a los personaes principales en los lugares del pais.
	 * @param pistas
	 */
	public void acumularPistas(List<Pista> pistas) {
		pistasAcumuladas.acumularPistas(pistas);
	}
	
	/**
	 * Se otorgan las pistas acumuladas del Pais.
	 * Estas pistas son propias de cada Pais.
	 * @return
	 */
	public List<Pista> darPistas(){
		return pistasAcumuladas.tirarPistas();
	}
	
	/**
	 * Cuando el Protagonista llega se deja una alerta de algun evento importante.
	 * PRE: No tiene.
	 * POST: El Protagonista recibe una alerta de algo importante o nada importante.
	 * @return
	 */
	public Alerta protagonistaHaLlegado() {
		return alerta;
	}

	/**
	 * Cuando el antagonista se ha dido, este ha dejado pistas en los distintos lugares.
	 * Los personajes secundarios han acumulado esas pistas.
	 * PRE:  Recibe un listado de pistas.
	 * POST: Las pistas acumuladas se dan a los personaes secundarios en los lugares del pais.
	 * @param pistas
	 */
	public void antagonistaHaPartido(List<Pista> pistas) {
		this.lugares.distribuirPistas(pistas);	
	}
	
	/**
	 * Al viajar debe estar inicialmente en el primer lugar disponible.
	 * @param viajero
	 */
	public void ubicarViajeroInicialmente(Viajero viajero) {
		viajero.visitar(lugares.obtenerLugar(0));
	}
	
	/**
	 * Agregar las pistas de cada pais.
	 */
	protected abstract List<Pista> crearMisPistas();
	
	/**
	 * Retorna si el pais es valido
	 * @return
	 */
	public abstract Boolean esValido();
}
