package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.PessoaEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Set;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {
    @Schema(description = "id do Endereço da PessoaEntity")
    private Integer idEndereco;

    private Set<PessoaEntity> pessoasEnderecosDTO;

}
