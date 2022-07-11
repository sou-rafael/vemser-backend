package br.com.vemser.pessoaapi.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Pessoa {
    @NotNull
    private Integer idPessoa;
    @NotEmpty(message = "nao pode ficar vazio")
    private String nome;
    @Past
    @NotNull
    private LocalDate dataNascimento;
    @Size(min=11, max=11)
    private String cpf;

}