package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoContato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@ToString
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;

}