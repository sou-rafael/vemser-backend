package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MailSender mailSender;
    private SimpleMailMessage templateMessage = new SimpleMailMessage();
    @Autowired
    public PropertieReader propertieReader;
    @Autowired
    public EmailService emailService;

    //    METODO DE VALIDAÇAO
    public boolean pessoaExiste(Integer idPessoa) {
        return pessoaRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
    }

    //  METODOS DE CONVERSAO
    public Pessoa convertToPessoa(PessoaCreateDTO pessoa) {
        Pessoa convertido = objectMapper.convertValue(pessoa, Pessoa.class);
        return convertido;
    }

    public PessoaDTO convertToPessoaDTO(Pessoa pessoa) {
        PessoaDTO convertido = objectMapper.convertValue(pessoa, PessoaDTO.class);
        return convertido;
    }

    public List<PessoaDTO> list() throws RegraDeNegocioException {
//        log.info();

        List<PessoaDTO> lista = pessoaRepository.listar()
                .stream()
                .map(pessoa -> convertToPessoaDTO(pessoa))
                .collect(Collectors.toList());

        return lista;
    }

    public List<PessoaDTO> listByName(String nome) throws RegraDeNegocioException {
        List<Pessoa> listaPessoa = pessoaRepository.listar().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
        List<PessoaDTO> listaPessoaDTO = listaPessoa.stream()
                .map(this::convertToPessoaDTO)
                .collect(Collectors.toList());

        return listaPessoaDTO;
    }

    private PessoaDTO getPessoa(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.listar().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));

        return convertToPessoaDTO(pessoaRecuperada);
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        Pessoa pessoaCriar = convertToPessoa(pessoa);
        Pessoa pessoaCriado = pessoaRepository.create(pessoaCriar);
        PessoaDTO confirm = convertToPessoaDTO(pessoaCriado);
//      ----------- ENVIAR EMAIL -----------------------
        emailService.sendPessoaCriada(confirm);
        return confirm;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecPESSOA = convertToPessoa(pessoaAtualizar);
        pessoaRecPESSOA.setCpf(pessoaAtualizar.getCpf());
        pessoaRecPESSOA.setNome(pessoaAtualizar.getNome());
        pessoaRecPESSOA.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecPESSOA.setEmail(pessoaAtualizar.getEmail());
        pessoaRecPESSOA.setIdPessoa(id);
        log.info("Service:dps de atualizada, pessoaRecPessoa = " + pessoaRecPESSOA);

        pessoaRepository.update(id, pessoaRecPESSOA);

//        ----------- ENVIAR EMAIL -----------------------
        PessoaDTO pessoaDTO = convertToPessoaDTO(pessoaRecPESSOA);
        emailService.sendPessoaAlterada(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        if (pessoaExiste(id)) {
            Pessoa pessoaApagar = pessoaRepository.listar().stream()
                    .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                    .findFirst().get();
            PessoaDTO pessoaApagarDTO = convertToPessoaDTO(pessoaApagar);
            emailService.sendPessoaExcluida(pessoaApagarDTO);
            pessoaRepository.delete(id);
        } else {
            throw new RegraDeNegocioException("A pessoa solicitada nao foi encontrada.");
        }
    }
}
