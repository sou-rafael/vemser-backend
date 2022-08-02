package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(this::convertToPetDTO)
                .collect(Collectors.toList());
    }

    public List<PetDTO> listPetPorIdPessoa(Integer idPessoa) {
        return petRepository.findAll().stream()
                .filter(p -> p.getIdPessoa().equals(idPessoa))
                .map(this::convertToPetDTO)
                .collect(Collectors.toList());
    }

    public PetDTO create(Integer idPessoa, PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        petCreateDTO.setIdPessoa(idPessoa);
        PetEntity petEntity = convertToPetEntity(petCreateDTO);
        petRepository.save(petEntity);

        return convertToPetDTO(petEntity);
    }

    public PetDTO update(Integer idPet, PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        PetEntity petEntity = convertToPetEntity(petCreateDTO);

        petEntity.setIdPet(idPet);

        return convertToPetDTO(petRepository.save(petEntity));
    }

    public void delete(Integer idPet) throws RegraDeNegocioException {
        try {
            PetEntity petEntity = buscarPetPorId(idPet);
            petRepository.delete(petEntity);
        } catch (RegraDeNegocioException re) {
            throw new RegraDeNegocioException("Pet invalido");
        }
    }

    //    METODOS DE CONVERSAO
    public PetEntity convertToPetEntity(PetCreateDTO petCreateDTO) {
        PetEntity petEntity = objectMapper.convertValue(petCreateDTO, PetEntity.class);
        return petEntity;
    }

    public PetDTO convertToPetDTO(PetEntity petEntity) {
        PetDTO petDTO = objectMapper.convertValue(petEntity, PetDTO.class);
        return petDTO;
    }

    //    METODO DE BUSCAR PELO ID
    public PetEntity buscarPetPorId(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet nao encontrado."));
    }
}
