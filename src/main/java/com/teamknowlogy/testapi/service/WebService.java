package com.teamknowlogy.testapi.service;

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
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;
import com.wordnik.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/mutation")
@Api(value = "main", description = "La API principal")
public class WebService {

	@Autowired
	private Mutations mutations;

	@ApiOperation(value = "Validación secuencia", notes = "validación de la secuencia")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Objeto JSON malformado") })
	@CrossOrigin(origins="*")
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Object> obtenerEstado(@RequestBody @Valid Secuence secuence, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		boolean result = mutations.hasMutation(secuence.getDna());

		return new ResponseEntity<>(
			result==true?
			HttpStatus.OK:
			HttpStatus.FORBIDDEN
		);
	}
}