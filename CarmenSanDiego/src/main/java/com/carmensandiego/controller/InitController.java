package com.carmensandiego.controller;

import java.util.HashMap;
import java.util.Map;

import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.pais.Alemania;
import com.carmensandiego.model.pais.Argentina;
import com.carmensandiego.model.pais.Australia;
import com.carmensandiego.model.pais.Canada;
import com.carmensandiego.model.pais.Egipto;
import com.carmensandiego.model.pais.Pais;

/**
 * Esta clase es responsable de controllar el llamado de crear el mundo
 * Tiene la tarea de
 *     1) Crear los Espacios y Paises inciales para el mundo
 *     2) Crear a los personajes secundarios poniendolos en el nuevo mundo
 *     3) Tirar las pistas al azar por todo el mundo
 * @author martin
 *
 */
public class InitController {
	
	private static InitController initController = null;
	private Mundo mundo;
	
	private InitController() {
		mundo = null;
	}
	
	public static  InitController getSingletonInstance() {
		if (initController == null)
			initController = new InitController();
		return initController;
	}
	
	public Mundo crearMundo(){
		this.mundo = Mundo.getSingletonInstance();
		this.mundo.agregarPaises(this.crearEspaciosYPaises());
		return mundo;
	}
	
	private Map<String,Pais> crearEspaciosYPaises() {
		Map<String,Pais> paises = new HashMap<String,Pais>();
		Pais alemania = new Alemania();
		paises.put("ALEMANIA", alemania);
		Pais argentina = new Argentina();
		paises.put("ARGENTINA", argentina);
		Pais espania = new Australia();
		paises.put("ESPANIA", espania);
		Pais egipto = new Egipto();
		paises.put("RUSIA", egipto);
		Pais canada = new Canada();
		paises.put("CANADA", canada);
		return paises;
	}
	
	private void crearYTirarPistas() {
		//TODO: Pensar las pistas iniciales que estan en cada pais.
	}
}