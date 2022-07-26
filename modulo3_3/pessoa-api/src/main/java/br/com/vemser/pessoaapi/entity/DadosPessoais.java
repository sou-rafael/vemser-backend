package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.Sexo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosPessoais {
    private String cnh;
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private Sexo sexo;
    private String tituloEleitor;
}
