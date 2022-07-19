package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.PessoaEnderecoEntity;
import br.com.vemser.pessoaapi.repository.PessoaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaEnderecoService {
    @Autowired
    private PessoaEnderecoRepository pessoaEnderecoRepository;

    public void associarEnderecoPessoa(Integer idPessoa, Integer idEndereco) {
        PessoaEnderecoEntity pessoaEnderecoEntity = new PessoaEnderecoEntity();
        pessoaEnderecoEntity.setIdPessoa(idPessoa);
        pessoaEnderecoEntity.setIdEndereco(idEndereco);

        pessoaEnderecoRepository.save(pessoaEnderecoEntity);
    }
    public List<PessoaEnderecoEntity> buscarEnderecoPorPessoa(Integer idPessoa){
        List<PessoaEnderecoEntity> p = pessoaEnderecoRepository.findAll().stream()
                .filter(e -> e.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
        return p;
    }
}
