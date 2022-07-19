package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "PESSOA")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "SEQ_PESSOA2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATA_NASCIMENTO")
    private String dataNascimento;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "EMAIL")
    private String email;

}

//@Getter(AccessLevel.NONE)
// USAR PARA RETIRAR DETERMINADO ATRIBUTO DOS GETTERS (neste caso para o nome não seria gerado getNome)