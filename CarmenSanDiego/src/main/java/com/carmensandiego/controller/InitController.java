package com.carmensandiego.controller;

import java.util.HashMap;
import java.util.Map;

import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.pais.Alemania;
import com.carmensandiego.model.pais.Argentina;
import com.carmensandiego.model.pais.Australia;
import com.carmensandiego.model.pais.Canada;
import com.carmensandiego.model.pais.ClavePais;
import com.carmensandiego.model.pais.Egipto;
import com.carmensandiego.model.pais.Pais;

/**
 * Esta clase es responsable de controllar el llamado de crear el mundo
 * Tiene la tarea de
 *     1) Crear los Espacios y Paises inciales para el mundo.
 *     2) Crear al Antagonista
 *     3) Crear a los personajes secundarios poniendolos en el nuevo mundo.
 * @author martin
 *
 */
public class InitController {
	
	private static InitController initController = null;
	private Mundo mundo = null;
	
	private InitController() {
		this.mundo = Mundo.getSingletonInstance();
	}
	
	public static  InitController getSingletonInstance() {
		if (initController == null)
			initController = new InitController();
		return initController;
	}
	
	public Mundo crearMundo(){
		this.mundo.agregarPaises(this.crearEspaciosYPaises());
		this.mundo.crearAntagonista();
		return mundo;
	}
	
	private Map<String,Pais> crearEspaciosYPaises() {
		Map<String,Pais> paises = new HashMap<String,Pais>();
		Pais alemania = new Alemania();
		paises.put(ClavePais.ALEMANIA.getKey(), alemania);
		Pais argentina = new Argentina();
		paises.put(ClavePais.ARGENTINA.getKey(), argentina);
		Pais australia = new Australia();
		paises.put(ClavePais.AUSTRALIA.getKey(), australia);
		Pais canada = new Canada();
		paises.put(ClavePais.CANADA.getKey(), canada);
		Pais egipto = new Egipto();
		paises.put(ClavePais.EGIPTO.getKey(), egipto);
		return paises;
	}
	
}