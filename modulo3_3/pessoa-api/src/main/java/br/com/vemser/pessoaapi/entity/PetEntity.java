package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.enums.TipoPet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PET")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "SEQ_PET", allocationSize = 1)
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    private TipoPet tipo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    private PessoaEntity pessoaPet;
}
