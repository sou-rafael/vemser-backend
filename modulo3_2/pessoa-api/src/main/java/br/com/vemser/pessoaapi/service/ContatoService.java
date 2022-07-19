package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = convertToContatoEntity(contatoCreateDTO);
        return convertToContatoDTO(contatoRepository.save(contatoEntity));
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream()
                .map(this::convertToContatoDTO)
                .collect(Collectors.toList());
    }


    public List<ContatoDTO> listContatoPorId(Integer idCont) throws RegraDeNegocioException {
        return contatoRepository.findAll().stream()
                .filter(e -> e.getIdContato().equals(idCont))
                .map(this::convertToContatoDTO)
                .collect(Collectors.toList());
    }

    //TODO verificar se esta funcionando
    public List<ContatoDTO> listContatoPorIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        List<ContatoDTO> lista = contatoRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(idPessoa))
                .map(this::convertToContatoDTO)
                .collect(Collectors.toList());

        return lista;
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        try {
            ContatoEntity contatoEntityRecuperada = buscarContatoPorId(idContato);
            if (contatoCreateDTO.getIdPessoa() != null)
                contatoEntityRecuperada.setIdPessoa(contatoCreateDTO.getIdPessoa());
            if (contatoCreateDTO.getTipoContato() != null)
                contatoEntityRecuperada.setTipoContato(contatoCreateDTO.getTipoContato());
            if (contatoCreateDTO.getNumero() != null)
                contatoEntityRecuperada.setNumero(contatoCreateDTO.getNumero());
            if (contatoCreateDTO.getDescricao() != null)
                contatoEntityRecuperada.setDescricao(contatoCreateDTO.getDescricao());

            return convertToContatoDTO(contatoRepository.save(contatoEntityRecuperada));
        } catch (RegraDeNegocioException r) {
            throw new RegraDeNegocioException("Contato invalido");
        }

    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        try {
            ContatoEntity contatoEntity = buscarContatoPorId(idContato);
            contatoRepository.delete(contatoEntity);
        } catch (RegraDeNegocioException re) {
            throw new RegraDeNegocioException("Contato invalido");
        }
    }


    //    METODOS DE CONVERSAO
    public ContatoEntity convertToContatoEntity(ContatoCreateDTO contatoCreateDTO) {
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        return contatoEntity;
    }

    public ContatoDTO convertToContatoDTO(ContatoEntity contatoEntity) {
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        return contatoDTO;
    }

    //    METODO DE BUSCAR PELO ID
    public ContatoEntity buscarContatoPorId(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado."));
    }
}
