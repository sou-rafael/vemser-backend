package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    //    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }
    private Pessoa pessoa = new Pessoa();

    public Pessoa create(Pessoa pessoa){
/*        //testes com obj pessoa
        boolean pessoaVazio = ObjectUtils.isEmpty(pessoa);
        boolean nomeEmBranco = StringUtils.isBlank(pessoa.getNome());
        boolean cpfTem11Num = pessoa.getCpf().matches("/d{11}");
        // validaçoes por anotaçoes

        if (!pessoaVazio && !nomeEmBranco && cpfTem11Num) {
            return pessoaRepository.create(pessoa);
        }else{
            throw new RegraDeNegocioException("Errou");
        }*/
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    //PUT
    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setIdPessoa(id);

        return pessoaRecuperada;
    }

    private Pessoa getPessoa(Integer id) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        return pessoaRecuperada;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRepository.getListaPessoas().remove(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
