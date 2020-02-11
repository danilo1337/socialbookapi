package com.algaworks.socialbooks.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.algaworks.socialbooks.dto.CepDto;

@Component
public class CepsService {
	public CepDto buscarPorEndereco(String cepParam) {
		RestTemplate template = new RestTemplate();
		String cep = cepParam.replace(".", "").replace("-", "");
		return template.getForObject("https://viacep.com.br/ws/{cep}/json", CepDto.class, cep);
	}
}
