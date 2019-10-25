package com.teamknowlogy.testapi.dto;

public class Secuence {
	private String [] dna;

	public Secuence () {
	}

	public Secuence (String [] dna) {
		this.dna = dna;
	}

	public String [] getDna () {
		return dna;
	}

	public void setDna (String [] dna) {
		this.dna = dna;
	}
}