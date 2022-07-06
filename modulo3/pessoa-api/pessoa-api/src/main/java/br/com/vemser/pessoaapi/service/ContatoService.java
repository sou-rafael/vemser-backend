package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;

    public ContatoService(){ contatoRepository = new ContatoRepository();}

    public List<Contato> listar(){return contatoRepository.listar();}
    public List<Contato> listarIdPessoa(Integer idPessoa){
        return contatoRepository.listarIdPessoa(idPessoa);
    }
    public Contato criar(Contato contato){
        return contatoRepository.criar(contato);
    }
    public Contato editar(Integer idContato, Contato contatoNovo) throws Exception {
        return contatoRepository.editar(idContato, contatoNovo);
    }
    public void apagar(Integer idContato) throws Exception {
        contatoRepository.apagar(idContato);
    }
}
