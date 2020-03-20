package com.apirest.DemoWebflux.controller;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.DemoWebflux.document.Cadastro;
import com.apirest.DemoWebflux.services.CadastroService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import java.util.concurrent.TimeUnit;

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
	
	@GetMapping(value="/cadastro/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public  Flux<Tuple2<Long, Cadastro>> getCadastroByEvents() {
		
		Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(10));
		Flux<Cadastro> events = service.findAll();
		System.out.println("OLHA O EVENTS PASSANDO AQUIIIIIII");
		return Flux.zip(intervalo, events);
	}
}

