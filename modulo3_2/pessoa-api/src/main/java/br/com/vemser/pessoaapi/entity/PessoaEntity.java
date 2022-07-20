package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "ID_PET", insertable = false, updatable = false)
    private Integer idPet;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PESSOA_X_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
    private Set<EnderecoEntity> enderecos;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PET", referencedColumnName = "ID_PET")
    private PetEntity pet;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY,
//            mappedBy = "PESSOA",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private Set<ContatoEntity> contatos;

}

//@Getter(AccessLevel.NONE)
// USAR PARA RETIRAR DETERMINADO ATRIBUTO DOS GETTERS (neste caso para o nome não seria gerado getNome)