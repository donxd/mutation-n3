package com.teamknowlogy.testapi.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class MutationsTest {

	Mutations mutations = new Mutations();

	@Test
	public void testHasMutationClean () {
		String [] dna = getSampleClean();
		boolean result = mutations.hasMutation(dna);
		assertFalse(result);
	}

	@Test
	public void testHasMutation1 () {
		String [] dna = getSampleMutation1();
		boolean result = mutations.hasMutation(dna);
		assertTrue(result);
	}

	@Test
	public void testHasMutation2 () {
		String [] dna = getSampleMutation2();
		boolean result = mutations.hasMutation(dna);
		assertTrue(result);
	}

	@Test
	public void testHasMutation3 () {
		String [] dna = getSampleMutation3();
		boolean result = mutations.hasMutation(dna);
		assertTrue(result);
	}

	@Test
	public void testHasMutation4 () {
		String [] dna = getSampleMutation4();
		boolean result = mutations.hasMutation(dna);
		assertTrue(result);
	}

	@Test
	public void testHasMutation5 () {
		String [] dna = getSampleMutation5();
		boolean result = mutations.hasMutation(dna);
		assertTrue(result);
	}

	@Test
	public void testHasMutation6 () {
		String [] dna = getSampleMutation6();
		boolean result = mutations.hasMutation(dna);
		assertTrue(result);
	}

	@Test
	public void testHasMutation7 () {
		String [] dna = getSampleMutation7();
		boolean result = mutations.hasMutation(dna);
		assertTrue(result);
	}

	String [] getSampleClean () {
		String [] dna = {
			"ATGCGA",
			"CAGTGC",
			"TTATTT",
			"AGACGG",
			"GCGTCA",
			"TCACTG"
		};
		return dna;
	}

	String [] getSampleMutation1 () {
		String [] dna = {
			"AAAAGA",
			"CATTAC",
			"TTAAGT",
			"AGAGTG",
			"CTCCTA",
			"TCACTG"
		};
		return dna;
	}

	String [] getSampleMutation2 () {
		String [] dna = {
			"ATGCGA",
			"CAGTAC",
			"TTGTGT",
			"AGGGTG",
			"CTCCTA",
			"TCACTG"
		};
		return dna;
	}

	String [] getSampleMutation3 () {
		String [] dna = {
			"ATGCGA",
			"CAGTAC",
			"TTATGT",
			"AGAATG",
			"CTCCTA",
			"TCACTG"
		};
		return dna;
	}

	String [] getSampleMutation4 () {
		String [] dna = {
			"ATGCGA",
			"CATTAC",
			"TTAAGT",
			"AGAGTG",
			"CTCCTA",
			"TCACTG"
		};
		return dna;
	}

	String [] getSampleMutation5 () {
		String [] dna = {
			"ATGCGA",
			"CATTAC",
			"TTATGT",
			"AGAGTG",
			"CTCCTA",
			"TCACTG"
		};
		return dna;
	}

	String [] getSampleMutation6 () {
		String [] dna = {
			"ATGCGA",
			"CACTAC",
			"TCATGT",
			"AGCGTG",
			"CTCCTA",
			"TCACCG"
		};
		return dna;
	}

	String [] getSampleMutation7 () {
		String [] dna = {
			"ATGCGA",
			"CACTAC",
			"TCATCT",
			"AGCCTG",
			"CTCATA",
			"TCACGG"
		};
		return dna;
	}

}
