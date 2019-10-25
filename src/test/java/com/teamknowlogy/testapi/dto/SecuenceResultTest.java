package com.teamknowlogy.testapi.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecuenceResultTest {

	@Test
	public void testSecuenceResult() {
		SecuenceResult secuenceResult = new SecuenceResult();
		
		assertNotNull(secuenceResult);
	}

	@Test
	public void testSecuenceResultStringBoolean() {
		String dna = "AAAA,AAAA,AAAA";
		boolean result = true;
		SecuenceResult secuenceResult = new SecuenceResult(dna, result);
		
		assertNotNull(secuenceResult);
		assertNotNull(secuenceResult.getDna());
		assertNotNull(secuenceResult.getResult());

		assertEquals(dna, secuenceResult.getDna());
		assertEquals(result, secuenceResult.getResult());
	}

	@Test
	public void testSecuenceResultIntStringBoolean() {
		int id = 1;
		String dna = "AAAA,AAAA,AAAA";
		boolean result = true;
		SecuenceResult secuenceResult = new SecuenceResult(id, dna, result);
		
		assertNotNull(secuenceResult);
		assertNotNull(secuenceResult.getId());
		assertNotNull(secuenceResult.getDna());
		assertNotNull(secuenceResult.getResult());
		
		assertEquals(id, secuenceResult.getId());
		assertEquals(dna, secuenceResult.getDna());
		assertEquals(result, secuenceResult.getResult());
	}

	@Test
	public void testId() {
		int id = 1;
		SecuenceResult secuenceResult = new SecuenceResult();
		secuenceResult.setId(id);
		
		assertNotNull(secuenceResult);
		assertNotNull(secuenceResult.getId());
		
		assertEquals(id, secuenceResult.getId());
	}

	@Test
	public void testDna() {
		String dna = "AAAA,AAAA,AAAA";
		SecuenceResult secuenceResult = new SecuenceResult();
		secuenceResult.setDna(dna);
		
		assertNotNull(secuenceResult);
		assertNotNull(secuenceResult.getDna());
		
		assertEquals(dna, secuenceResult.getDna());
	}

	@Test
	public void testResult() {
		boolean result = true;
		SecuenceResult secuenceResult = new SecuenceResult();
		secuenceResult.setResult(result);
		
		assertNotNull(secuenceResult);
		assertNotNull(secuenceResult.getResult());
		
		assertEquals(result, secuenceResult.getResult());
	}

}
