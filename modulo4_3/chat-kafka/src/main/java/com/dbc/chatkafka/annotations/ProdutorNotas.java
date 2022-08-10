package com.dbc.chatkafka.annotations;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "200", description = "Sucesso! Nova mensagem enviada com sucesso"),
                @ApiResponse(responseCode = "403", description = "Ops, observe o que esta sendo enviado!"),
                @ApiResponse(responseCode = "500", description = "Erro! Durante a execução foi gerada uma exceção")
        }
)
public @interface ProdutorNotas {
}
