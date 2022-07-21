package br.com.vemser.pessoaapi.service;


import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    //----------------------------------------------------------------------------------------------------------------------------------
    public List<PessoaDTO> listarComEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
                        pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecosPessoa().stream().toList());
                        return pessoaDTO;
                            })
                    .toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
                        pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecosPessoa().stream().toList());
                        return pessoaDTO;
                    }).toList();
        }
    }

//todo
    public List<PessoaDTO> listarComContatos(Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
                        pessoaDTO.setContatosDTO(pessoaEntity.getContatosPessoa().stream().toList());
                        return pessoaDTO;
                    })
                    .toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
                        pessoaDTO.setContatosDTO(pessoaEntity.getContatosPessoa().stream().toList());
                        return pessoaDTO;
                    }).toList();
        }
    }
    //todo
    public List<PessoaDTO> listarComPets(Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(pessoaEntity.getPetPessoa());
                        return pessoaDTO;
                    })
                    .toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(pessoaEntity.getPetPessoa());
                        return pessoaDTO;
                    }).toList();
        }
    }
//------ HOMEWORK AULA3 ------------------------------------------------------------------------------------------------------------------
    public Page<RelatorioPersonalizadoDTO> listarPessoaCompleto(@RequestParam(required = false) Integer idPessoa, Pageable pageable){
        return pessoaRepository.relatorioPersonalizadoDTO(idPessoa, pageable);
    }


//----------------------------------------------------------------------------------------------------------------------------------

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

    public ContatoDTO convertToContatoDTO(ContatoEntity contatoEntity) {
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public EnderecoDTO convertToEnderecoDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public PetDTO convertToPetDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }


    //    METODO DE BUSCAR PELO ID
    public PessoaEntity buscarPessoaPorId(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa nao encontrada."));
    }
    public PessoaDTO buscarPessoaDTOPorId(Integer id) throws RegraDeNegocioException {
        return convertToPessoaDTO(pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa nao encontrada.")));
    }
}
