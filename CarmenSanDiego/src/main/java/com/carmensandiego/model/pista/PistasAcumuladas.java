package com.carmensandiego.model.pista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PistasAcumuladas {
	
	private List<Pista> pistas;
	
	public PistasAcumuladas() {
		this.pistas = new ArrayList<Pista>();
	}
	
	public List<Pista> getPistas() {
		return this.pistas;
	}
	
	public void acumularPista(Pista pista) {
		this.pistas.add(pista);
	}
	
	public void acumularPistas(Collection<Pista> pistas) {
		if(pistas != null) this.pistas.addAll(pistas);
	}

	/**
	 * Tira las pistas acumuladas.
	 * PRE: Ninguno
	 * POST: Limpia el listado de pistas acumuladas. No hay mas pistas.
	 * @return
	 */
	public List<Pista> tirarPistas(){
		List<Pista> pistas = this.pistas
								 .stream()
								 .collect(Collectors.toList());
		this.pistas.clear();
		return pistas;
	}
}
