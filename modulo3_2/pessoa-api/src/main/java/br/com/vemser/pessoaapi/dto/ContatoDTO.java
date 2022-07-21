package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.PessoaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    @Schema(description = "id do ContatoEntity")
    private Integer idContato;

    private PessoaEntity pessoa;
}