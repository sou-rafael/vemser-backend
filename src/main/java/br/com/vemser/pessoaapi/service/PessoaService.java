package br.com.vemser.pessoaapi.service;


import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = convertToPessoaEntity(pessoaCreateDTO);
        return convertToPessoaDTO(pessoaRepository.save(pessoaEntity));
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(this::convertToPessoaDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(p -> p.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(this::convertToPessoaDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer idPessoa, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = buscarPessoaPorId(idPessoa);
        pessoaEntityRecuperada.setNome(pessoaCreateDTO.getNome());
        pessoaEntityRecuperada.setCpf(pessoaCreateDTO.getCpf());
        pessoaEntityRecuperada.setEmail(pessoaCreateDTO.getEmail());
        pessoaEntityRecuperada.setDataNascimento(pessoaCreateDTO.getDataNascimento());

        return convertToPessoaDTO(pessoaRepository.save(pessoaEntityRecuperada));
    }

    public void delete(Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = buscarPessoaPorId(idPessoa);
        pessoaRepository.delete(pessoaEntity);
    }


    //    METODOS DE CONVERSAO
    public PessoaEntity convertToPessoaEntity(PessoaCreateDTO pessoaCreateDTO) {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        return pessoaEntity;
    }

    public PessoaDTO convertToPessoaDTO(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        return pessoaDTO;
    }

    //    METODO DE BUSCAR PELO ID
    public PessoaEntity buscarPessoaPorId(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa nao encontrada."));
    }
}
