package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class EnderecoCreateDTO {
    @Schema(description = "id da Pessoa que possui o Endereço")
    private Integer idPessoa;
    @NotNull
    @Schema(description = "tipo do Endereço")
    private TipoEndereco tipo;
    @NotEmpty
    @Size(min = 1, max = 250, message = "Verifique o tamanho de no maximo 250")
    @Schema(description = "logradouro do Endereço")
    private String logradouro;
    @NotNull
    @Schema(description = "numero do imovel do Endereço")
    private Integer numero;
    @Schema(description = "complemento para o Endereço")
    private String complemento;
    @NotEmpty
    @Size(min = 8, max = 9)
    @Schema(description = "cep do Endereço")
    private String cep;
    @NotEmpty
    @Size(min = 1, max = 250)
    @Schema(description = "cidade do Endereço")
    private String cidade;
    @NotBlank
    @Schema(description = "estado do Endereço")
    private String estado;
    // @Getter(AccessLevel.none)
    @NotBlank
    @Schema(description = "pais do Endereço")
    private String pais;
}
