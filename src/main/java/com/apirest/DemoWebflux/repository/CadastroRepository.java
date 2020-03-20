package com.apirest.DemoWebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.DemoWebflux.document.Cadastro;

// com essa classe {reactive mongodb} ja teremos acesso a diversos métodos prontos
public interface CadastroRepository extends ReactiveMongoRepository<Cadastro, String>{

}
