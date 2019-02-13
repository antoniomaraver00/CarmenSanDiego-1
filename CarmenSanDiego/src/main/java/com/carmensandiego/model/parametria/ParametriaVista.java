package com.carmensandiego.model.parametria;

public enum ParametriaVista {
	
	WIDTH(1440),
	HEIGHT(900);
	
	private Integer value;
	
	private ParametriaVista(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}

}
