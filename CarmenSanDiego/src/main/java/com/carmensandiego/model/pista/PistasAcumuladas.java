package com.carmensandiego.model.pista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PistasAcumuladas {
	
	private List<Pista> pistas;
	
	public PistasAcumuladas() {
		this.pistas = new ArrayList<Pista>();
	}
	
	public void acumularPista(Pista pista) {
		this.pistas.add(pista);
	}
	
	public void acumularPistas(Collection<Pista> pistas) {
		if(pistas != null) this.pistas.addAll(pistas);
	}

	public List<Pista> getPistas() {
		return this.pistas;
	}
	
	public List<Pista> tirarPistas(){
		List<Pista> pistas = new ArrayList<Pista>();
		for (Pista pista : this.pistas) {
			pistas.add(pista);
		}
		this.pistas.clear();
		return pistas;
	}
}
