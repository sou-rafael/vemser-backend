package br.com.vemser.pessoaapi.entity;

import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Accessors(chain = true)
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
//    @NotNull
    private TipoContato tipoContato;
//    @NotEmpty
//    @Size(min = 1, max = 13)
    private String numero;
//    @NotEmpty
    private String descricao;

}
