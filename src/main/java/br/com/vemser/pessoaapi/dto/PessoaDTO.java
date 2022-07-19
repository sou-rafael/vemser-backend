package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PessoaDTO extends PessoaCreateDTO {
    @Schema(description = "id da PessoaEntity")
    private Integer idPessoa;
}
