package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.TipoContato;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CON_SEQ")
    @SequenceGenerator(name = "CON_SEQ", sequenceName = "SEQ_CONTATO", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;

    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "TIPO")
    private TipoContato tipoContato;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    private PessoaEntity pessoa;

}
