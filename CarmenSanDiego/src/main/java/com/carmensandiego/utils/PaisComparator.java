package com.carmensandiego.utils;

import java.util.Comparator;

import com.carmensandiego.model.pais.Pais;

/**
 * Clase responsable de ordenar los paises.
 * Compara por Nombre del pais y ordena alfabeticamente.
 * @author Tincho
 *
 */
public class PaisComparator implements Comparator<Pais>{
	
	private static PaisComparator paisComparator = new PaisComparator();

	/** Compara los nombres de los paises y retorna
	 * 	-1 : Si el Primer Pais tiene un orden alfabetico menor (Sus letras estan antes en el alfabeto)
	 *   0 : Sus nombres son iguales
	 *   1 : Si el primer Pais tiene un orden alfabetico mayor (Sus letras estan despues en el alfabeto) 
	 * PRE: Recibe dos paises.
	 * POST: Retorna el orden del primer pais con respecto al segundo.
	 */
	@Override
	public int compare(Pais pais1, Pais pais2) {
		return pais1.getNombre().compareTo(pais2.getNombre());
	}
	
	public static PaisComparator alfabeticOrder() {
		return paisComparator;
	}

}
