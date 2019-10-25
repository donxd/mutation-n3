package com.teamknowlogy.testapi.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatTest {

	@Test
	public void testStat() {
		Stat stat = new Stat();
		
		assertNotNull(stat);
	}

	@Test
	public void testStatIntIntFloat() {
		int noMutations = 1;
		int noClean = 2;
		float ratio = (float) 1/2;
		Stat stat = new Stat(noMutations, noClean, ratio);
		
		assertNotNull(stat);
		assertNotNull(stat.getCountMutations());
		assertNotNull(stat.getCountNoMutation());
		assertNotNull(stat.getRatio());
		
		assertEquals(noMutations, stat.getCountMutations());
		assertEquals(noClean, stat.getCountNoMutation());
		assertEquals(Float.compare(ratio, stat.getRatio()), 0);
	}

	@Test
	public void testGetCountMutations() {
		int noMutations = 1;
		Stat stat = new Stat();
		stat.setCountMutations(noMutations);
		
		assertNotNull(stat);
		assertNotNull(stat.getCountMutations());
		
		assertEquals(noMutations, stat.getCountMutations());
	}

	@Test
	public void testGetCountNoMutation() {
		int noClean = 2;
		Stat stat = new Stat();
		stat.setCountNoMutation(noClean);
		
		assertNotNull(stat);
		assertNotNull(stat.getCountNoMutation());
		
		assertEquals(noClean, stat.getCountNoMutation());
	}

	@Test
	public void testGetRatio() {
		float ratio = (float) 1/2;
		Stat stat = new Stat();
		stat.setRatio(ratio);
		
		assertNotNull(stat);
		assertNotNull(stat.getRatio());
		
		assertEquals(Float.compare(ratio, stat.getRatio()), 0);
	}

}
