package br.com.vemser.pessoaapi.service;


import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
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
                        return mapEnderecosPessoa(pessoaEntity);
                    })
                    .toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        return mapEnderecosPessoa(pessoaEntity);
                    }).toList();
        }
    }

    @NotNull
    private PessoaDTO mapEnderecosPessoa(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
        pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecosPessoa().stream()
                .map(this::convertToEnderecoDTO)
                .toList());
        return pessoaDTO;
    }

    //    ===========================================================================================
    public List<PessoaDTO> listarComContatos(Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(pessoaEntity -> {
                        return mapContatosPessoa(pessoaEntity);
                    })
                    .toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity -> {
                        return mapContatosPessoa(pessoaEntity);
                    }).toList();
        }
    }

    @NotNull
    private PessoaDTO mapContatosPessoa(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
        pessoaDTO.setContatosDTO(pessoaEntity.getContatosPessoa().stream()
                .map(this::convertToContatoDTO)
                .toList());
        return pessoaDTO;
    }

    //    ===========================================================================================
    public List<PessoaDTO> listarComPets(Integer idPessoa) throws RegraDeNegocioException {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa).stream()
                    .map(this::mapPetPessoa)
                    .toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(this::mapPetPessoa)
                    .toList();
        }
    }

    public PessoaDTO mapPetPessoa(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);
        pessoaDTO.setPetDTO(convertToPetDTO(pessoaEntity.getPetPessoa()));
        return pessoaDTO;
    }

    //------ HOMEWORK AULA3 ------------------------------------------------------------------------------------------------------------------
    //--------------- correção Pessoa Completo: generalizar mapeamento de entity para dto  ---------------------------------------------------

    public List<PessoaDTO> listarPessoaCompleto(Integer idPessoa) {
        if (idPessoa != null) {
            return pessoaRepository.findById(idPessoa)
                    .map(this::mapPessoaCompleta)
                    .stream()
                    .toList();
        } else {
            return pessoaRepository.findAll()
                    .stream().map(this::mapPessoaCompleta)
                    .toList();
        }

    }

    public PessoaDTO mapPessoaCompleta(PessoaEntity pessoaEntity) {

        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaEntity);

        pessoaDTO.setEnderecosDTO(pessoaEntity.getEnderecosPessoa().stream()
                .map(this::convertToEnderecoDTO)
                .toList());
        pessoaDTO.setContatosDTO(pessoaEntity.getContatosPessoa().stream()
                .map(this::convertToContatoDTO).toList());
        pessoaDTO.setPetDTO(convertToPetDTO(pessoaEntity.getPetPessoa()));
        return pessoaDTO;
    }
    //----------------------------------------------------------------------------------------------------------------------------------

    public Page<RelatorioPersonalizadoDTO> listarRelatorioPessoa(@RequestParam(required = false) Integer idPessoa,
                                                                 @RequestParam Integer pagina,
                                                                 @RequestParam Integer quantRegistros) {
        Pageable pageable = PageRequest.of(pagina, quantRegistros, Sort.by("idPessoa"));
        return pessoaRepository.relatorioPersonalizadoDTO(idPessoa, pageable);
    }


//----------------------------------------------------------------------------------------------------------------------------------

    public PessoaDTO update(Integer idPessoa, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = convertOptionalToPessoaEntity(pessoaRepository.findById(idPessoa));

        pessoaEntity.setNome(pessoaCreateDTO.getNome());
        pessoaEntity.setCpf(pessoaCreateDTO.getCpf());
        pessoaEntity.setEmail(pessoaCreateDTO.getEmail());
        pessoaEntity.setDataNascimento(pessoaCreateDTO.getDataNascimento());

        return convertToPessoaDTO(pessoaRepository.save(pessoaEntity));
    }

    public void delete(Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = convertOptionalToPessoaEntity(pessoaRepository.findById(idPessoa));
        pessoaRepository.delete(pessoaEntity);
    }

    //    ===========================================================================================
    //    METODOS DE CONVERSAO
    public PessoaEntity convertToPessoaEntity(PessoaCreateDTO pessoaCreateDTO) {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        return pessoaEntity;
    }

    public PessoaDTO convertToPessoaDTO(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        return pessoaDTO;
    }

    public PessoaEntity convertOptionalToPessoaEntity(Optional optional) {
        return objectMapper.convertValue(optional, PessoaEntity.class);
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

}
