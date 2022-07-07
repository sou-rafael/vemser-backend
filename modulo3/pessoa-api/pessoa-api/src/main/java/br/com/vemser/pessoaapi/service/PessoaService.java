package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }
    private Pessoa pessoa = new Pessoa();
    public PessoaService() {
    }

    public Pessoa create(Pessoa pessoa) throws Exception{
        //testes com obj pessoa
        boolean pessoaVazio = ObjectUtils.isEmpty(pessoa);
        boolean nomeEmBranco = StringUtils.isBlank(pessoa.getNome());
        boolean cpfTem11Num = pessoa.getCpf().matches("/d{11}");

        if (!pessoaVazio && !nomeEmBranco && cpfTem11Num){
        return pessoaRepository.create(pessoa);}
        return null;
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

//PUT
    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }
    public void delete(Integer id) throws Exception{
        pessoaRepository.delete(id);
    }
    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
