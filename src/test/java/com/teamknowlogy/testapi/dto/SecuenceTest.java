package com.teamknowlogy.testapi.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecuenceTest {

	@Test
	public void testSecuence() {
		Secuence secuence = new Secuence();
		assertNotNull(secuence);
	}

	@Test
	public void testSecuenceStringArray() {
		String [] dna = new String [] {"AAAA","AAAA","AAAA","AAAA","AAAA"};
		Secuence secuence = new Secuence(dna);
		
		assertNotNull(secuence);
		assertNotNull(secuence.getDna());
		assertArrayEquals(dna, secuence.getDna());
	}

	@Test
	public void testGetDna() {
		String [] dna = new String [] {"AAAA","AAAA","AAAA","AAAA","AAAA"};
		Secuence secuence = new Secuence();
		secuence.setDna(dna);
		
		assertNotNull(secuence);
		assertNotNull(secuence.getDna());
		assertArrayEquals(dna, secuence.getDna());
	}

	@Test
	public void testSetDna() {
		String [] dna = new String [] {"AAAA","AAAA","AAAA","AAAA","AAAA"};
		Secuence secuence = new Secuence();
		secuence.setDna(dna);
		
		assertNotNull(secuence);
		assertNotNull(secuence.getDna());
		assertArrayEquals(dna, secuence.getDna());
	}

}
