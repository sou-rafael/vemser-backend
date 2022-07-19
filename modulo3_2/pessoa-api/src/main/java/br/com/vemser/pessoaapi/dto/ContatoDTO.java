package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ContatoDTO extends ContatoCreateDTO{
    @Schema(description = "id do ContatoEntity")
    private Integer idContato;
}