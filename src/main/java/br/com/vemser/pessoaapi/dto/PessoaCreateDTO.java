package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaCreateDTO {
    @NotBlank
    @NotEmpty(message = "nao pode ficar vazio")
    @Schema(description = "Nome da PessoaEntity")
    private String nome;
    @Past
    @NotNull
    @Schema(description = "data de nascimento da PessoaEntity")
    private String dataNascimento;
    @Size(min = 11, max = 11)
    @Schema(description = "cpf da PessoaEntity")
    private String cpf;
    @Schema(description = "e-mail da PessoaEntity")
    private String email;


}
