package com.algaworks.socialbooks.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.dto.CepDto;
import com.algaworks.socialbooks.services.CepsService;

@RestController
@RequestMapping("/ceps")
public class CepsResources {
	
	@RequestMapping(value ="/{cep}", method = RequestMethod.GET)
	public ResponseEntity<CepDto> buscarCep(@PathVariable("cep") String cep){
		CepDto cepDto = new CepsService().buscarPorEndereco(cep);
		System.err.println(cepDto);
		return ResponseEntity.status(HttpStatus.OK).body(cepDto);
	}
}
