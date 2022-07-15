package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Pessoa;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "id da Pessoa")
    private Integer idPessoa;
}
