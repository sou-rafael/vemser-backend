package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContatoCreateDTO {
    @Schema(description = "id da PessoaEntity responsavel pelo ContatoEntity")
    private Integer idPessoa;
    @NotNull
    @Schema(description = "tipo do ContatoEntity")
    private TipoContato tipoContato;
    @NotEmpty
    @Size(min = 1, max = 13)
    @Schema(description = "numero do ContatoEntity")
    private String numero;
    @NotEmpty
    @Schema(description = "descrição do ContatoEntity")
    private String descricao;

}

