package com.carmensandiego.model.lugar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.carmensandiego.model.pista.Pista;

public class Lugares {
	
	private List<Lugar> lugares;
	
	public Lugares() {
		lugares = new ArrayList<Lugar>();
	}
	
	public Lugares(Collection<Lugar> lugares) {
		lugares = new ArrayList<Lugar>(lugares);
	}
	
	public List<Lugar> getLugares(){
		return lugares;
	}
	
	public Lugar obtenerLugar(Integer index) {
		return lugares.get(index);
	}
	
	public void agregarLugar(Lugar lugar) {
		lugares.add(lugar);
	}
	
	public void distribuirPistas(List<Pista> pistas) {
		Integer indexLugar = 0;
		for (Pista pista : pistas) {
			if(indexLugar == lugares.size())
				indexLugar = 0;
			lugares.get(indexLugar).informarPista(pista);
			indexLugar++;
		}
	}

}
