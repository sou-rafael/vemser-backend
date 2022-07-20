package br.com.vemser.pessoaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetDTO extends PetCreateDTO{
    private Integer idPet;
}
