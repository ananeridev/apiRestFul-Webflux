package com.apirest.DemoWebflux;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

// vai ser uma classe de confirguração do Spring Framework
//@Configuration
public class CadastroRouter {

	@Bean
	public RouterFunction<ServerResponse> route(CadastroHandler handler){
		return RouterFunctions
				.route(GET("/cadastro").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/cadastro/{Id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/cadastro").and(accept(MediaType.APPLICATION_JSON)), handler::save);
			
	}
}
