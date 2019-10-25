package com.teamknowlogy.testapi.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamknowlogy.testapi.business.Mutations;
import com.teamknowlogy.testapi.dto.Secuence;
import com.teamknowlogy.testapi.dto.SecuenceResult;
import com.teamknowlogy.testapi.dto.Stat;
import com.teamknowlogy.testapi.repository.SecuenceResultRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/")
@Api(value = "main", description = "La API principal")
public class WebService {

	@Autowired
	private Mutations mutations;

	@Autowired
	private SecuenceResultRepository secuenceResultRepository;

	@ApiOperation(value = "Validación secuencia", notes = "Validación de la secuencia")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Objeto JSON malformado") })
	@CrossOrigin(origins="*")
	@RequestMapping(value="mutation/", method=RequestMethod.POST)
	public ResponseEntity<Object> validateSecuence(@RequestBody @Valid Secuence secuence, BindingResult bindingResult){

		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		String secuenceDna = String.join(",", secuence.getDna());
		List<SecuenceResult> secuencesResultStored = secuenceResultRepository.findByDna(secuenceDna);

		boolean result;
		if (secuencesResultStored.isEmpty()) {
			result = mutations.hasMutation(secuence.getDna());
			SecuenceResult secuenceResult = new SecuenceResult(secuenceDna, result);
			secuenceResultRepository.save(secuenceResult);
			System.out.println("stored");
		} else {
			result = secuencesResultStored.get(0).getResult();
			System.out.println("readed");
		}

		return resolveSecuence(result);
	}

	private ResponseEntity<Object> resolveSecuence (boolean result) {
		return new ResponseEntity<>(
			result==true?
			HttpStatus.OK:
			HttpStatus.FORBIDDEN
		);
	}

	@ApiOperation(value = "Estadísticas de secuencias", notes = "Estadísticas de las secuencias procesadas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
	@CrossOrigin(origins="*")
	@RequestMapping(value="stats/", method=RequestMethod.GET)
	public ResponseEntity<Stat> showStats(){
		int numberSecuencesClean = secuenceResultRepository.findByResult(false).size();
		int numberSecuencesMutated = secuenceResultRepository.findByResult(true).size();
		float ratio = numberSecuencesClean > 0 ? ((float) numberSecuencesMutated / numberSecuencesClean) : numberSecuencesMutated;
		Stat response = new Stat(numberSecuencesMutated, numberSecuencesClean, ratio);

		return new ResponseEntity<Stat> (response,HttpStatus.OK);
	}
}