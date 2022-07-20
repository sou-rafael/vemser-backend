package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.enums.TipoPet;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetCreateDTO {
    private Integer idPessoa;
    private String nome;
    private TipoPet tipo;
}
