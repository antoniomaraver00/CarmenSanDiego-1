package com.carmensandiego.model.parametria;

public enum ParametriaTime {

	/**
	 * Tiempo inicial del juego en DIAS.
	 */
	INIT_TIME(7L),
	
	/**
	 * Tiempo de viaje en HORAS.
	 */
	TRAVEL_TIME(8L),
	
	/**
	 * Tiempo de visita en HORAS
	 */
	VISIT_TIME(2L);
	
	private Long value;
	
	private ParametriaTime(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return this.value;
	}
}
