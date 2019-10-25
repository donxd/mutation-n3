package com.teamknowlogy.testapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secuences")
public class SecuenceResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String dna;
	private boolean result;

	public SecuenceResult () {
	}
	
	public SecuenceResult (String dna, boolean result) {
		this.dna = dna;
		this.result = result;
	}

	public SecuenceResult (int id, String dna, boolean result) {
		this.id = id;
		this.dna = dna;
		this.result = result;
	}

	public int getId () {
		return id;
	}

	public void setId (int id) {
		this.id = id;
	}

	public String getDna () {
		return dna;
	}

	public void setDna (String dna) {
		this.dna = dna;
	}

	public boolean getResult () {
		return result;
	}

	public void setResult (boolean result) {
		this.result = result;
	}
}