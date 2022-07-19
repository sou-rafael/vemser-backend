package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.TipoContato;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CON_SEQ")
    @SequenceGenerator(name = "CON_SEQ", sequenceName = "SEQ_CONTATO", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;

    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "TIPO")
    private TipoContato tipoContato;
    private String numero;
    private String descricao;

}
