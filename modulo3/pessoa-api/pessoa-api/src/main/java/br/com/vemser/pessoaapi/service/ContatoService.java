package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.ObjNulo;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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


    //testar se pessoa existe criei um metodo para fazer o teste no POST e PUT
    private boolean pessoaExiste(Contato contato) {
        return contatoRepository.listarIdPessoa(contato.getIdPessoa()).isEmpty();
    }

    public Contato criar(Contato contato) throws Exception {
        if (pessoaExiste(contato)) {
            log.info("Pessoa existe, criando o contato");
            return contatoRepository.criar(contato);
        } else {
            log.warn("Deu erro... nao reconheceu pessoa");
            throw new Exception("A pessoa informada nao existe");
        }
    }

    public Contato editar(Integer idContato, Contato contatoNovo) throws Exception {
        boolean idContatoExiste = contatoRepository.listar().stream()
                .anyMatch(contato -> contato.getIdContato().equals(idContato));

        if (idContatoExiste && pessoaExiste(contatoNovo)) {
            Contato contatoAtual = contatoRepository.listar().stream()
                    .filter(contato -> contato.getIdContato().equals(idContato))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Contato nao encontrado"));
            contatoAtual.setIdPessoa(contatoNovo.getIdPessoa());
            contatoAtual.setTipoContato(contatoNovo.getTipoContato());
            contatoAtual.setNumero(contatoNovo.getNumero());
            contatoAtual.setDescricao(contatoNovo.getDescricao());
            return contatoAtual;
        } else throw new Exception("Pessoa ou contato inexistentes");
    }

    public void apagar(Integer idContato) throws Exception {
        boolean contatoExiste = (contatoRepository.listar().stream()
                .filter(contato -> contato.getIdContato().equals(idContato)).count() > 0);

        Contato contato = contatoRepository.listarIdPessoa(idContato).stream().findFirst().orElseThrow();
        if (contatoExiste && pessoaExiste(contato)) {
            contatoRepository.apagar(idContato);
        }
        throw new Exception("O contato nao existe.");
    }
}
//    Contato contatoApagar = listaContatos.stream()
//            .filter(contato -> contato.getIdContato().equals(idContato))
//            .findFirst()
//            .orElseThrow(() -> new Exception("Contato nao encontrado"));
//        listaContatos.remove(contatoApagar);