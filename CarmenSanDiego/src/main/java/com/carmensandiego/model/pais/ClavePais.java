package com.carmensandiego.model.pais;

public enum ClavePais {
	
	ALEMANIA("ALEMANIA"),
	ARGENTINA("ARGENTINA"),
	AUSTRALIA("AUSTRALIA"),
	CANADA("CANADA"),
	EGIPTO("EGIPTO");
	
	private String key;
	
	private ClavePais(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}

}
