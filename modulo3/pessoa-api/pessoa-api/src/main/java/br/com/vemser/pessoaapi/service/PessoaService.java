package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    private ObjectMapper objectMapper;

    //POST
    public Pessoa create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaDTO.build();
        pessoaRepository.create(pessoa);
        return pessoa;
    }

    public List<Pessoa> list() throws RegraDeNegocioException {
        // nao posso retornar o objectMapper -- NPE?
        log.info("Passou na Service, mas esta antes de tudo");
        List<Pessoa> lista = pessoaRepository.listar();
        log.info("Passou na Service, PESQUISOU NA LISTA DO REPOSITORY");

        return lista;
    }

    //PUT todo
    public Pessoa update(Integer id, PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecPESSOA = getPessoa(id);

        pessoaRecPESSOA.setCpf(pessoaAtualizar.getCpf());
        pessoaRecPESSOA.setNome(pessoaAtualizar.getNome());
        pessoaRecPESSOA.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecPESSOA.setIdPessoa(id);
        log.info("Service:dps de atualizada, pessoaRecPessoa = " + pessoaRecPESSOA);

        //voltar para classe PessoaDTO para dar o retorno neste tipo?
        return pessoaRecPESSOA;
    }

    private Pessoa getPessoa(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));

        return pessoaRecuperada;
    }

    // DELETE
    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRepository.getListaPessoas().remove(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
//        passando a pesquisa direto como argumento no ObjectMapping
        return pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public boolean pessoaExiste(Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoaDaLista = getPessoa(idPessoa);
        Pessoa pessoaEncontrada = objectMapper.convertValue(pessoaDaLista, Pessoa.class);
        return pessoaRepository.listar().contains(pessoaEncontrada);
    }
}
