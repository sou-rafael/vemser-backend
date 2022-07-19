package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class DadosPessoaisDTO {
    @Schema(description = "CNH dos Dados Pessoais")
    private String cnh;
    @Schema(description = "CPF dos Dados Pessoais")
    private String cpf;
    @Schema(description = "Nome dos Dados Pessoais")
    private String nome;
    @Schema(description = "Nome da Mae dos Dados Pessoais")
    private String nomeMae;
    @Schema(description = "Nome do Pai dos Dados Pessoais")
    private String nomePai;
    @Schema(description = "RG dos Dados Pessoais")
    private String rg;
    @Schema(description = "Sexo dos Dados Pessoais")
    private Sexo sexo;
    @Schema(description = "Titulo de Eleitor dos Dados Pessoais")
    private String tituloEleitor;
}
