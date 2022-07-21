package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
public class PessoaDTO extends PessoaCreateDTO {
    @Schema(description = "id da PessoaEntity")
    private Integer idPessoa;

    private PetEntity petDTO;

    private List<EnderecoEntity> enderecosDTO;

    private List<ContatoEntity> contatosDTO;
}
