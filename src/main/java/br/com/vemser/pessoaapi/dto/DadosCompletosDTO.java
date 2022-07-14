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

    public DadosCompletosDTO(Integer idPessoa, String nome, String dataNascimento, String cpf, String email, Integer idEndereco, TipoEndereco tipo, String logradouro, Integer numeroEnd, String complemento, String cep, String cidade, String estado, String pais, Integer idContato, TipoContato tipoContato, String numeroCont, String descricao, String cnh, String nomeMae, String nomePai, String rg, Sexo sexo, String tituloEleitor) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.idEndereco = idEndereco;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numeroEnd = numeroEnd;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.idContato = idContato;
        this.tipoContato = tipoContato;
        this.numeroCont = numeroCont;
        this.descricao = descricao;
        this.cnh = cnh;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.rg = rg;
        this.sexo = sexo;
        this.tituloEleitor = tituloEleitor;
    }
}
