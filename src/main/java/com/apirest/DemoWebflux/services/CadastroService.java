package com.apirest.DemoWebflux.services;

import com.apirest.DemoWebflux.document.Cadastro;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CadastroService {

	// nao retorna uma lista, retorna um tipo flux
	Flux<Cadastro> findAll();
	Mono<Cadastro> findById(String id);
	Mono<Cadastro> save(Cadastro cadastro);
}
