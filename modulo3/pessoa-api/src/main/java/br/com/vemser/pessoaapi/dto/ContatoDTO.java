package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ContatoDTO extends ContatoCreateDTO{
    @Schema(description = "id do Contato")
    private Integer idContato;

}