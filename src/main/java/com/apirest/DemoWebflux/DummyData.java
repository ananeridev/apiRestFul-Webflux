package com.apirest.DemoWebflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apirest.DemoWebflux.document.Cadastro;
import com.apirest.DemoWebflux.repository.CadastroRepository;

import reactor.core.publisher.Flux;

// com essa classe é onde vamos popular os dados no nosso banco de dados

// essa anotação é para que ela seja um bean gerenciado pelo sprinf framework
//@Component
//public class DummyData implements CommandLineRunner{
//
//private final CadastroRepository cadastroRepository;
//
//DummyData(CadastroRepository cadastroRepository) {
//	
//	this.cadastroRepository = cadastroRepository;
//}
//
//@Override
//public void run(String...args) throws Exception {
//	
//	cadastroRepository.deleteAll()
//			.thenMany(
//					Flux.just("Joana", "Erick", "Ana" , "AAAAA" , "BBBBBb" , "CCCCCC")
//					.map(nome -> new Cadastro (UUID.randomUUID().toString(), nome))
//					.flatMap(cadastroRepository::save))
//				
//			.subscribe(System.out::println);
//}
//
//}
