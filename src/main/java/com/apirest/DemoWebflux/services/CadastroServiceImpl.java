package com.apirest.DemoWebflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.DemoWebflux.document.Cadastro;
import com.apirest.DemoWebflux.repository.CadastroRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


//Essa classe vai implementar os metodos no interface
@Service
public class CadastroServiceImpl implements CadastroService{
	
	@Autowired
	CadastroRepository cr;
	
	@Override
	public Flux<Cadastro> findAll() {
		return cr.findAll();
	}

	@Override
	public Mono<Cadastro> findById(String id) {
		return cr.findById(id);
	}

	@Override
	public Mono<Cadastro> save(Cadastro cadastro) {
		return cr.save(cadastro);
	}

	
}
