package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Sexo;
import br.com.vemser.pessoaapi.entity.TipoContato;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DadosCompletosDTO {
    private Integer idPessoa;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;


    private Integer idEndereco;
    private TipoEndereco tipo;
    private String logradouro;
    private Integer numeroEnd;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;


    private Integer idContato;
    private TipoContato tipoContato;
    private String numeroCont;
    private String descricao;


    private String cnh;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private Sexo sexo;
    private String tituloEleitor;

}
