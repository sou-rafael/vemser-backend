package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContatoCreateDTO {
    @Schema(description = "id da Pessoa responsavel pelo Contato")
    private Integer idPessoa;
    @NotNull
    @Schema(description = "tipo do Contato")
    private TipoContato tipoContato;
    @NotEmpty
    @Size(min = 1, max = 13)
    private String numero;
    @NotEmpty
    private String descricao;

}

