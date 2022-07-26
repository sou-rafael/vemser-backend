package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.enums.MessageType;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaEnderecoService pessoaEnderecoService;

    @Autowired
    private PessoaService pessoaService;


    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = convertToEnderecoEntity(enderecoCreateDTO);
        PessoaEntity pessoaEntityValida = pessoaService.buscarPessoaPorId(idPessoa);

        enderecoEntity.setPessoasEnderecos(Set.of(pessoaEntityValida));
        PessoaDTO pessoaValidaDTO = pessoaService.convertToPessoaDTO(pessoaEntityValida);

        EnderecoEntity enderecoEntity1 = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoCriadoDTO1 = convertToEnderecoDTO(enderecoEntity1);

        return enderecoCriadoDTO1;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(this::convertToEnderecoDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByCity(String cidade) {
        return enderecoRepository.findAll().stream()
                .filter(e -> e.getCidade().toUpperCase().contains(cidade.toUpperCase()))
                .map(this::convertToEnderecoDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listEnderecoPorId(Integer idEnd) throws RegraDeNegocioException {
        return enderecoRepository.findAll().stream()
                .filter(e -> e.getIdEndereco().equals(idEnd))
                .map(this::convertToEnderecoDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listEnderecoPorIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        List<EnderecoDTO> lista = new ArrayList<>();

        List<PessoaEnderecoEntity> enderecos = pessoaEnderecoService.buscarEnderecoPorPessoa(idPessoa);

        for (PessoaEnderecoEntity e : enderecos) {
            lista.add((EnderecoDTO) enderecoRepository.findAll().stream()
                    .filter(end -> end.getIdEndereco().equals(e.getIdEndereco())));
        }
        return lista;
    }

    //TODO -- verificar este metodo
    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        try {
            EnderecoEntity enderecoEntityRecuperada = buscarEnderecoPorId(idEndereco);
            if (enderecoCreateDTO.getLogradouro() != null)
                enderecoEntityRecuperada.setLogradouro(enderecoCreateDTO.getLogradouro());
            if (enderecoCreateDTO.getNumero() != null)
                enderecoEntityRecuperada.setNumero(enderecoCreateDTO.getNumero());
            if (enderecoCreateDTO.getComplemento() != null)
                enderecoEntityRecuperada.setComplemento(enderecoCreateDTO.getComplemento());
            if (enderecoCreateDTO.getTipo() != null)
                enderecoEntityRecuperada.setTipo(enderecoCreateDTO.getTipo());
            if (enderecoCreateDTO.getCep() != null)
                enderecoEntityRecuperada.setCep(enderecoCreateDTO.getCep());
            if (enderecoCreateDTO.getCidade() != null)
                enderecoEntityRecuperada.setCidade(enderecoCreateDTO.getCidade());
            if (enderecoCreateDTO.getEstado() != null)
                enderecoEntityRecuperada.setEstado(enderecoCreateDTO.getEstado());
            if (enderecoCreateDTO.getPais() != null)
                enderecoEntityRecuperada.setPais(enderecoCreateDTO.getPais());

            return convertToEnderecoDTO(enderecoRepository.save(enderecoEntityRecuperada));
        } catch (RegraDeNegocioException r) {
            throw new RegraDeNegocioException("Contato invalido");
        }

    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        try {
            EnderecoEntity enderecoEntity = buscarEnderecoPorId(idEndereco);
            enderecoRepository.delete(enderecoEntity);
        } catch (RegraDeNegocioException re) {
            throw new RegraDeNegocioException("Endereco invalido");
        }
    }


    //    METODOS DE CONVERSAO
    public EnderecoEntity convertToEnderecoEntity(EnderecoCreateDTO enderecoCreateDTO) {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        return enderecoEntity;
    }

    public EnderecoDTO convertToEnderecoDTO(EnderecoEntity enderecoEntity) {
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        return enderecoDTO;
    }

    //    METODO DE BUSCAR PELO ID
    public EnderecoEntity buscarEnderecoPorId(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco nao encontrada."));
    }
}
