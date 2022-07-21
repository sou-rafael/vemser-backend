package br.com.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RelatorioPersonalizadoDTO {
    //Pessoa
    private Integer idPessoa;
    private String nome;
    private String email;

    //Contato
    private String numero;

    //Endereco
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    //Pet
    private String nomePet;
}
