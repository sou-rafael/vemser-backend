package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class PessoaCompletoDTO {
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private Set<EnderecoEntity> enderecosPessoa;
    private PetEntity petPessoa;
    private Set<ContatoEntity> contatosPessoa;

}
