package com.apirest.DemoWebflux;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.apirest.DemoWebflux.services.CadastroServiceImpl;
import com.apirest.DemoWebflux.document.Cadastro;
import com.apirest.DemoWebflux.services.CadastroService;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import reactor.core.publisher.Mono;

import reactor.core.publisher.Mono;

//@Component
public class CadastroHandler {

	@Autowired
	CadastroService service;
	
	// mesmo retornando uma lista tem que colocar o ServerResponse, o mesmo faz parte da API reativa do spring framework
	public Mono<ServerResponse> findAll(ServerRequest request) {
		
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Cadastro.class);
	}
	
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		String Id = request.pathVariable("Id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(Id), Cadastro.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Cadastro> playlist = request.bodyToMono(Cadastro.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(service::save), Cadastro.class));
	}
}
