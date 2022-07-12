package br.com.vemser.pessoaapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnderecoDTO extends EnderecoCreateDTO {
    private Integer idEndereco;

}
