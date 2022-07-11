package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Contato;
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

    //    METODO DE VALIDAÇAO
    public boolean pessoaExiste(Integer idPessoa) {
        return pessoaRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
    }

    //  METODOS DE CONVERSAO
    public Pessoa convertToPessoa(PessoaCreateDTO pessoa) {
        Pessoa pessoaConvertido = objectMapper.convertValue(pessoa, Pessoa.class);
        return pessoaConvertido;
    }

    public PessoaDTO convertToPessoaDTO(Pessoa pessoa) {
        PessoaDTO pessoaConvertido = objectMapper.convertValue(pessoa, PessoaDTO.class);
        return pessoaConvertido;
    }

    public List<PessoaDTO> list() throws RegraDeNegocioException {

        List<PessoaDTO> lista = pessoaRepository.listar()
                .stream().map(this::convertToPessoaDTO)
                .collect(Collectors.toList());

        return lista;
    }

    public List<PessoaDTO> listByName(String nome) throws RegraDeNegocioException {
        List<Pessoa> listaPessoa = pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
        List<PessoaDTO> listaPessoaDTO = listaPessoa.stream()
                .map(this::convertToPessoaDTO)
                .collect(Collectors.toList());

        return listaPessoaDTO;
    }

    private PessoaDTO getPessoa(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.getListaPessoas().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));

        return convertToPessoaDTO(pessoaRecuperada);
    }
    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        Pessoa pessoaCriar = convertToPessoa(pessoa);

        Pessoa pessoaCriado = pessoaRepository.create(pessoaCriar);
        PessoaDTO confirm = convertToPessoaDTO(pessoaCriado);
        return confirm;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecPESSOA = convertToPessoa(pessoaAtualizar);
        pessoaRecPESSOA.setCpf(pessoaAtualizar.getCpf());
        pessoaRecPESSOA.setNome(pessoaAtualizar.getNome());
        pessoaRecPESSOA.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecPESSOA.setIdPessoa(id);
        log.info("Service:dps de atualizada, pessoaRecPessoa = " + pessoaRecPESSOA);

        return convertToPessoaDTO(pessoaRecPESSOA);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        if (pessoaExiste(id)) {
            pessoaRepository.delete(id);
        } else {
            throw new RegraDeNegocioException("O contato solicitado nao foi encontrado.");
        }
    }
}
