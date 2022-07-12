package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.ObjNulo;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private PessoaRepository pessoaRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    //    METODOS DE VALIDAÇÃO
    public boolean contatoExiste(Integer idContato) {
        return contatoRepository.listar().stream()
                .anyMatch(contato -> contato.getIdContato().equals(idContato));
    }

    public boolean pessoaExiste(Integer idPessoa) {
        return pessoaRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
    } // TODO verificar na repo da pessoa -- FEITO!

    //    MÉTODOS DE CONVERSAO
    public Contato convertToContato(ContatoCreateDTO contato) {
        Contato contatoConvertido = objectMapper.convertValue(contato, Contato.class);
        return contatoConvertido;
    }

    public ContatoDTO convertToContatoDTO(Contato contato) {
        ContatoDTO contatoConvertido = objectMapper.convertValue(contato, ContatoDTO.class);
        return contatoConvertido;
    }


    public List<ContatoDTO> listar() throws RegraDeNegocioException {

        List<ContatoDTO> lista = contatoRepository.listar()
                .stream().map(this::convertToContatoDTO)
                .collect(Collectors.toList());

        return lista;
    }

    public List<ContatoDTO> listarIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        if (pessoaExiste(idPessoa)) {
            return this.listar().stream()
                    .filter(contatoDTO -> contatoDTO.getIdPessoa().equals(idPessoa))
                    .collect(Collectors.toList());
        } else throw new RegraDeNegocioException("Pessoa solicitada nao existe");
    }


    public ContatoDTO criar(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException {
        if (pessoaExiste(idPessoa)) {

            Contato contatoCriar = convertToContato(contato);

            Contato contatoCriado = contatoRepository.criar(idPessoa, contatoCriar);
            ContatoDTO confirm = convertToContatoDTO(contatoCriado);
            return confirm;
        } else {
            throw new RegraDeNegocioException("Pessoa solicitada nao existe");
        }
    }

    public ContatoDTO editar(Integer idContato, ContatoCreateDTO contatoNovo) throws RegraDeNegocioException {

        if (contatoExiste(idContato) && pessoaExiste(contatoNovo.getIdPessoa())) {

            Contato contatoAtual = new Contato();
            contatoAtual = convertToContato(contatoNovo);
            log.info("ContatoAtual antes de receber os sets = " + contatoAtual);

            contatoAtual.setIdContato(idContato);

            ContatoDTO contatoAtualDTO = new ContatoDTO();
            contatoAtualDTO = convertToContatoDTO(contatoAtual);

            return contatoAtualDTO;

        } else {
            throw new RegraDeNegocioException("Pessoa ou contato inexistentes");
        }
    }

    public void apagar(Integer idContato) throws RegraDeNegocioException {

        if (contatoExiste(idContato)) {
            log.info("Passou pelo if");
            contatoRepository.apagar(idContato);
            log.info("Foi ao repository e voltou");
        } else {
            throw new RegraDeNegocioException("O contato solicitado nao foi encontrado.");
        }
    }
}
