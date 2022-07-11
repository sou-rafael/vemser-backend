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

    public EnderecoCreateDTO build() {
        EnderecoCreateDTO endereco = new EnderecoCreateDTO()
                .setIdPessoa(super.getIdPessoa())
                .setTipo(super.getTipo())
                .setLogradouro(super.getLogradouro())
                .setNumero(super.getNumero())
                .setComplemento(super.getComplemento())
                .setCep(super.getCep())
                .setCidade(super.getCidade())
                .setEstado(super.getEstado())
                .setPais(super.getPais());
        return endereco;
    }
}
