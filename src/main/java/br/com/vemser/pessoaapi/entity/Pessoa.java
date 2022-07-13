package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {
    private Integer idPessoa;
//    @NotEmpty(message = "nao pode ficar vazio")
    //@Getter(AccessLevel.NONE)
    private String nome;
//    @Past
//    @NotNull
    private String dataNascimento;
//    @Size(min=11, max=11)
    private String cpf;
    private String email;

}

//@Getter(AccessLevel.NONE)
// USAR PARA RETIRAR DETERMINADO ATRIBUTO DOS GETTERS (neste caso para o nome não seria gerado getNome)