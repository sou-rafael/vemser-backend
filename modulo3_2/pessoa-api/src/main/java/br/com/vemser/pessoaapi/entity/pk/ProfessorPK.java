package br.com.vemser.pessoaapi.entity.pk;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class ProfessorPK implements Serializable {
    @Column(name = "ID_PROFESSOR")
    private Integer idProfessor;

    @Column(name = "ID_UNIVERSIDADE")
    private Integer idUniversidade;
}
