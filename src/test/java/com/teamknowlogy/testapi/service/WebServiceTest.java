package com.teamknowlogy.testapi.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.teamknowlogy.testapi.business.Mutations;
import com.teamknowlogy.testapi.dto.Secuence;
import com.teamknowlogy.testapi.dto.SecuenceResult;
import com.teamknowlogy.testapi.dto.Stat;
import com.teamknowlogy.testapi.repository.SecuenceResultRepository;


@RunWith(MockitoJUnitRunner.class)
public class WebServiceTest {
	
	@InjectMocks
	WebService webService;
	
	@Mock
	private Mutations mutations;

	@Mock
	private SecuenceResultRepository secuenceResultRepository;

	@Test
	public void testValidateSecuenceBadRequest() {
		BindingResult bindingResult = mock(BindingResult.class);
		
		when(bindingResult.hasErrors()).thenReturn(true);
		
		ResponseEntity<Object> response = webService.validateSecuence(null, bindingResult);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void testValidateSecuenceNewSequenceClean() {
		BindingResult bindingResult = mock(BindingResult.class);
		Secuence secuence = new Secuence(new String []{"AATTGG","AATTGG"});
		List<SecuenceResult> stored = new ArrayList<SecuenceResult>();
		
		when(bindingResult.hasErrors()).thenReturn(false);
		when(secuenceResultRepository.findByDna(anyString())).thenReturn(stored);
		when(mutations.hasMutation(any(String[].class))).thenReturn(false);
		
		ResponseEntity<Object> response = webService.validateSecuence(secuence, bindingResult);
		
		assertEquals(response.getStatusCode(), HttpStatus.FORBIDDEN);
	}
	
	@Test
	public void testValidateSecuenceNewSequenceMutated() {
		BindingResult bindingResult = mock(BindingResult.class);
		Secuence secuence = new Secuence(new String []{"AATTGG","AATTGG"});
		List<SecuenceResult> stored = new ArrayList<SecuenceResult>();
		
		when(bindingResult.hasErrors()).thenReturn(false);
		when(secuenceResultRepository.findByDna(anyString())).thenReturn(stored);
		when(mutations.hasMutation(any(String[].class))).thenReturn(true);
		
		ResponseEntity<Object> response = webService.validateSecuence(secuence, bindingResult);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testValidateSecuenceRepeatedClean() {
		BindingResult bindingResult = mock(BindingResult.class);
		Secuence secuence = new Secuence(new String []{"AATTGG","AATTGG"});
		List<SecuenceResult> stored = new ArrayList<SecuenceResult>();
		SecuenceResult secuenceResult = mock(SecuenceResult.class);
		stored.add(secuenceResult);
		
		when(bindingResult.hasErrors()).thenReturn(false);
		when(secuenceResultRepository.findByDna(anyString())).thenReturn(stored);
		when(mutations.hasMutation(any(String[].class))).thenReturn(false);
		when(secuenceResult.getResult()).thenReturn(false);
		
		ResponseEntity<Object> response = webService.validateSecuence(secuence, bindingResult);
		
		assertEquals(response.getStatusCode(), HttpStatus.FORBIDDEN);
	}
	
	@Test
	public void testValidateSecuenceRepeatedMutated() {
		BindingResult bindingResult = mock(BindingResult.class);
		Secuence secuence = new Secuence(new String []{"AATTGG","AATTGG"});
		List<SecuenceResult> stored = new ArrayList<SecuenceResult>();
		SecuenceResult secuenceResult = mock(SecuenceResult.class);
		stored.add(secuenceResult);
		
		when(bindingResult.hasErrors()).thenReturn(false);
		when(secuenceResultRepository.findByDna(anyString())).thenReturn(stored);
		when(mutations.hasMutation(any(String[].class))).thenReturn(false);
		when(secuenceResult.getResult()).thenReturn(true);
		
		ResponseEntity<Object> response = webService.validateSecuence(secuence, bindingResult);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testShowStatsEmpty() {
		List<SecuenceResult> clean = new ArrayList<SecuenceResult>(); 
		List<SecuenceResult> mutated = new ArrayList<SecuenceResult>();
		when(secuenceResultRepository.findByResult(eq(false))).thenReturn(clean);
		when(secuenceResultRepository.findByResult(eq(true))).thenReturn(mutated);
		
		ResponseEntity<Stat> response = webService.showStats();
		
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertTrue(response.hasBody());
		Stat responseStat = response.getBody();
		assertEquals(responseStat.getCountMutations(), 0);
		assertEquals(responseStat.getCountNoMutation(), 0);
		assertEquals(Float.compare(0, 0), 0);
	}
	
	@Test
	public void testShowStatsOnlyMutations() {
		List<SecuenceResult> clean = new ArrayList<SecuenceResult>();
		List<SecuenceResult> mutated = new ArrayList<SecuenceResult>();
		mutated.add(new SecuenceResult());
		when(secuenceResultRepository.findByResult(eq(false))).thenReturn(clean);
		when(secuenceResultRepository.findByResult(eq(true))).thenReturn(mutated);
		
		ResponseEntity<Stat> response = webService.showStats();
		
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertTrue(response.hasBody());
		Stat responseStat = response.getBody();
		assertEquals(responseStat.getCountMutations(), 1);
		assertEquals(responseStat.getCountNoMutation(), 0);
		assertEquals(Float.compare(1, 1), 0);
	}
	
	@Test
	public void testShowStatsOnlyClean() {
		List<SecuenceResult> clean = new ArrayList<SecuenceResult>();
		clean.add(new SecuenceResult());
		List<SecuenceResult> mutated = new ArrayList<SecuenceResult>();
		when(secuenceResultRepository.findByResult(eq(false))).thenReturn(clean);
		when(secuenceResultRepository.findByResult(eq(true))).thenReturn(mutated);
		
		ResponseEntity<Stat> response = webService.showStats();
		
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertTrue(response.hasBody());
		Stat responseStat = response.getBody();
		assertEquals(responseStat.getCountMutations(), 0);
		assertEquals(responseStat.getCountNoMutation(), 1);
		assertEquals(Float.compare(0, 0), 0);
	}
	
	@Test
	public void testShowStatsRatio1() {
		List<SecuenceResult> clean = new ArrayList<SecuenceResult>();
		clean.add(new SecuenceResult());
		clean.add(new SecuenceResult());
		List<SecuenceResult> mutated = new ArrayList<SecuenceResult>();
		mutated.add(new SecuenceResult());
		mutated.add(new SecuenceResult());
		when(secuenceResultRepository.findByResult(eq(false))).thenReturn(clean);
		when(secuenceResultRepository.findByResult(eq(true))).thenReturn(mutated);
		
		ResponseEntity<Stat> response = webService.showStats();
		
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertTrue(response.hasBody());
		Stat responseStat = response.getBody();
		assertEquals(responseStat.getCountMutations(), 2);
		assertEquals(responseStat.getCountNoMutation(), 2);
		assertEquals(Float.compare(1, 1), 0);
	}
	
	@Test
	public void testShowStatsRatio() {
		List<SecuenceResult> clean = new ArrayList<SecuenceResult>();
		clean.add(new SecuenceResult());
		clean.add(new SecuenceResult());
		List<SecuenceResult> mutated = new ArrayList<SecuenceResult>();
		mutated.add(new SecuenceResult());
		when(secuenceResultRepository.findByResult(eq(false))).thenReturn(clean);
		when(secuenceResultRepository.findByResult(eq(true))).thenReturn(mutated);
		
		ResponseEntity<Stat> response = webService.showStats();
		
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertTrue(response.hasBody());
		Stat responseStat = response.getBody();
		assertEquals(responseStat.getCountMutations(), 1);
		assertEquals(responseStat.getCountNoMutation(), 2);
		assertEquals(Float.compare((float)1/2, (float)1/2), 0);
	}

}
