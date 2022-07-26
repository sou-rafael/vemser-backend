package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.PessoaEntity;
import lombok.*;

@Data
public class PetDTO extends PetCreateDTO{
    private Integer idPet;

    private PessoaEntity pessoaPet;
}
