package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.TipoEndereco;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "END_SEQ")
    @SequenceGenerator(name = "END_SEQ", sequenceName = "SEQ_ENDERECO_CONTATO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;
    private TipoEndereco tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
}

