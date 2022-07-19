package br.com.vemser.pessoaapi.annotations;
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
                @ApiResponse(responseCode = "200", description = "Sucesso!!"),
                @ApiResponse(responseCode = "401", description = "Ação não autorizada."),
                @ApiResponse(responseCode = "400", description = "Bad Request. Verifique seus parâmetros"),
                @ApiResponse(responseCode = "404", description = "Página não encontrada."),
                @ApiResponse(responseCode = "500", description = "Error interno.")
        }
)
public @interface Notas {
}
