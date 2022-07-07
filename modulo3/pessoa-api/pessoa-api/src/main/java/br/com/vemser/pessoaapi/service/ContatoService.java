package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exceptions.ObjNulo;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

//    public ContatoService(){ contatoRepository = new ContatoRepository();}

    public List<Contato> listar() {
        return contatoRepository.listar();
    }

    public List<Contato> listarIdPessoa(Integer idPessoa) {
        return contatoRepository.listarIdPessoa(idPessoa);
    }


    //CORRIGIDO - testar se pessoa existe
    public Contato criar(Contato contato) throws Exception {
        boolean contatoEsta = contatoRepository.listar().stream()
                .anyMatch(contatoA -> contatoA.getIdContato().equals(contato.getIdContato()));
        if (contatoEsta) {
            return contatoRepository.criar(contato);
        } else throw new Exception("Contato nao esta na lista");
    }

    public Contato editar(Integer idContato, Contato contatoNovo) throws Exception {
        boolean contatoEsta = contatoRepository.listar().stream()
                .anyMatch(contato -> contato.getIdContato().equals(idContato));

        if (contatoEsta) {
            Contato contatoAtual = contatoRepository.listar().stream()
                    .filter(contato -> contato.getIdContato().equals(idContato))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Contato nao encontrado"));
            contatoAtual.setIdPessoa(contatoNovo.getIdPessoa());
            contatoAtual.setTipoContato(contatoNovo.getTipoContato());
            contatoAtual.setNumero(contatoNovo.getNumero());
            contatoAtual.setDescricao(contatoNovo.getDescricao());
            return contatoAtual;
        } else throw new Exception("Contato nao esta na lista");
    }

    public void apagar(Integer idContato) throws Exception {
        contatoRepository.apagar(idContato);
    }
}
