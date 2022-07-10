package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Pessoa;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PessoaDTO extends PessoaCreateDTO {
    @NotNull
    private Integer idPessoa;

    public Pessoa build() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(super.getNome());
        pessoa.setCpf(super.getCpf());
        pessoa.setDataNascimento(super.getDataNascimento());

        return pessoa;
    }

}
