package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String nome;
    @Past
    @NotNull
    private String dataNascimento;
    @Size(min = 11, max = 11)
    private String cpf;

    private String email;


}
