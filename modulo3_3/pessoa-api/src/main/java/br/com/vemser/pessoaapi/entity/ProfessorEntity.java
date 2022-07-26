package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.entity.pk.ProfessorPK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "PROFESSOR")
public class ProfessorEntity {
    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SALARIO")
    private Double salario;

}
