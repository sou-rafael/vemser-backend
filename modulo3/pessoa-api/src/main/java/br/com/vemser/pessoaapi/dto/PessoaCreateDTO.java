package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaCreateDTO {
    @NotBlank
    @NotEmpty(message = "nao pode ficar vazio")
    @Schema(description = "Nome da Pessoa")
    private String nome;
    @Past
    @NotNull
    @Schema(description = "data de nascimento da Pessoa")
    private String dataNascimento;
    @Size(min = 11, max = 11)
    @Schema(description = "cpf da Pessoa")
    private String cpf;
    @Schema(description = "e-mail da Pessoa")
    private String email;


}
