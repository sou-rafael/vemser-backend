package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.entity.TipoContato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "86 988337121", "fixo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.RESIDENCIAL, "86 33343334", "casa"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "86 22221111", "whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "86 777788889", "casa"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.COMERCIAL, "86 88889999", "fixo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.RESIDENCIAL, "86 33332222", "whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.COMERCIAL, "86 987665232", "fixo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.RESIDENCIAL, "86 988365412", "whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.COMERCIAL, "86 65676567", "fixo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, TipoContato.RESIDENCIAL, "86 111111111", "casa"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, TipoContato.COMERCIAL, "86 99997121", "whatsapp"));
    }

    //GET listar todos
    public List<Contato> listar() {
        return listaContatos;
    }

    //POST com idPessoa
    public Contato criar(Integer idPessoa, Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(idPessoa);
        listaContatos.add(contato);
        return contato;
    }

    public void apagar(Integer idContato) throws RegraDeNegocioException {
        Contato contatoApagar = listar().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst().get();
        log.info("Contato para apagar = "+contatoApagar);

        listaContatos.remove(contatoApagar);
    }

/*
    //  GET por pessoa - receber idPessoa e listar todos os contatos da pessoa;

    public List<Contato> listarIdPessoa(Integer idPessoa) {
        return null;
    }

    //  PUT com idContato

    public Contato editar(Integer idContato, Contato contatoNovo) throws Exception {

        return null;
    }
*/
}
