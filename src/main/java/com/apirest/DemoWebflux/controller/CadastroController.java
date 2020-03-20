package com.apirest.DemoWebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.DemoWebflux.document.Cadastro;
import com.apirest.DemoWebflux.services.CadastroService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CadastroController  {


	@Autowired
	CadastroService service;
	

	@GetMapping(value="/cadastro")
	public Flux <Cadastro> getCadastro(){
		return service.findAll();
	}
	
	
	@GetMapping(value="/cadastro/{Id}")
	public Mono<Cadastro> getCadastroId(@PathVariable String Id) {
		
		return service.findById(Id);
		
	}
	
	
	//Request body é pra saber que ele vai estar recebendo uma lista em formato json
	@PostMapping(value="/cadastro")
	public Mono<Cadastro> save( @RequestBody Cadastro cadastro) {
		
		return service.save(cadastro);
	}
}

