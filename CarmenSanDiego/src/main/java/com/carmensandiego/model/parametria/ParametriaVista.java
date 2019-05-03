package com.carmensandiego.model.parametria;

public enum ParametriaVista {
	
	/**
	 * Ancho de ventana
	 */
	WIDTH(1440),
	/**
	 * Alto de ventana
	 */
	HEIGHT(900);
	
	private Integer value;
	
	private ParametriaVista(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}

}
