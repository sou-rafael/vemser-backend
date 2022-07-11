package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    //    metodos de conversão
    public Endereco covertToEndereco(EnderecoCreateDTO enderecoCreateDTO) {
        Endereco convertido = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        return convertido;
    }

    public EnderecoDTO convertToEnderecoDTO(Endereco end) {
        EnderecoDTO enderecoConverted = objectMapper.convertValue(end, EnderecoDTO.class);
        return enderecoConverted;
    }

    // metodos de validação
    public boolean endExiste(Integer idEndereco) {
        return enderecoRepository.listar().stream()
                .anyMatch(endereco -> endereco.getIdEndereco().equals(idEndereco));
    }

    public boolean pessoaExiste(Integer idPessoa) {
        return enderecoRepository.listar().stream()
                .anyMatch(endereco -> endereco.getIdPessoa().equals(idPessoa));
    }

    //GET /endereco -- listar todos

    public List<EnderecoDTO> listar() {
        return enderecoRepository.listar().stream().map(this::convertToEnderecoDTO).collect(Collectors.toList());
    }

    //GET /endereco/{idEndereco} -- recupera o endereco especifico

    public List<EnderecoDTO> listarIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        if (endExiste(idEndereco)) {
            return enderecoRepository.listarIdEndereco(idEndereco).stream().map(this::convertToEnderecoDTO).collect(Collectors.toList());
        }
        throw new RegraDeNegocioException("Endereco solicitado nao exite");
    }
    //GET /endereco/{idPessoa}/pessoa -- recupera endereços por pessoa

    public List<EnderecoDTO> listarEnderecoPorIdPessoa(Integer idPessoa) throws RegraDeNegocioException {

        if (pessoaExiste(idPessoa)) {
            return enderecoRepository.listarEnderecoPorIdPessoa(idPessoa).stream()
                    .map(this::convertToEnderecoDTO)
                    .collect(Collectors.toList());
        }
        throw new RegraDeNegocioException("A pessoa solicitada nao existe");
    }

    //POST /endereco/{idPessoa} -- recebe a pessoa, o endereco e cria o endereco com id da pessoa
    public EnderecoDTO criar(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        boolean pessoaExiste = enderecoRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
//        boolean logradouroEmBranco = StringUtils.isBlank(endereco.getLogradouro()); -- isso agora é validado no LomBok
        if (pessoaExiste) {
            return convertToEnderecoDTO(enderecoRepository.criar(idPessoa, endereco));
        } else throw new RegraDeNegocioException("O endereco nao eh valido ou nao esta na lista.");
    }

    //PUT /endereco/{idEndereco} --  altera os dados do endereço.
    public EnderecoDTO editar(Integer idEndereco, EnderecoCreateDTO enderecoNovo) throws RegraDeNegocioException {
        if (endExiste(idEndereco)){
            return convertToEnderecoDTO(enderecoRepository.editar(idEndereco, enderecoNovo));
        } else throw new RegraDeNegocioException("O endereco nao esta na lista");
    }

    //TODO
    //DELETE “/endereco/{idEndereco}” -- remove o endereço pelo id
    public void apagar(Integer idEndereco) throws RegraDeNegocioException {
        if (endExiste(idEndereco)) {
            log.info("Passou pelo if(endExiste)");
            enderecoRepository.apagar(idEndereco);
        }
    }
}
