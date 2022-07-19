package br.com.vemser.pessoaapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "PESSOA_X_PESSOA_ENDERECO")
public class PessoaEnderecoEntity {
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;
}
