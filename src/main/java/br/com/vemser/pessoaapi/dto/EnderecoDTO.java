package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnderecoDTO extends EnderecoCreateDTO {
    @Schema(description = "id do Endereço da PessoaEntity")
    private Integer idEndereco;

}
