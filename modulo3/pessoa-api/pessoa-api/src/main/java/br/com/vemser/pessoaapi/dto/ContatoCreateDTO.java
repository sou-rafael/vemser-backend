package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.TipoContato;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContatoCreateDTO {
    private Integer idPessoa;
    @NotNull
    private TipoContato tipoContato;
    @NotEmpty
    @Size(min = 1, max = 13)
    private String numero;
    @NotEmpty
    private String descricao;

//    public Contato build() {
//
//        Contato contato = new Contato()
//                .setIdPessoa(this.idPessoa)
//                .setTipoContato(this.tipoContato)
//                .setNumero(this.numero)
//                .setDescricao(this.descricao);
//        return contato;
//    }


}

