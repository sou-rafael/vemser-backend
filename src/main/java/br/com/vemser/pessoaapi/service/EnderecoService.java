package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.MessageType;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.properties.PropertieReader;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MailSender mailSender;

    private SimpleMailMessage templateMessage = new SimpleMailMessage();
    @Autowired
    private PropertieReader propertieReader;
    @Autowired
    private EmailService emailService;

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
        return pessoaRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
    }

    public List<EnderecoDTO> listar() {
        return enderecoRepository.listar().stream()
                .map(this::convertToEnderecoDTO)
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listarIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        if (endExiste(idEndereco)) {
            return enderecoRepository.listarIdEndereco(idEndereco).stream().map(this::convertToEnderecoDTO).collect(Collectors.toList());
        }
        throw new RegraDeNegocioException("Endereco solicitado nao exite");
    }

    public List<EnderecoDTO> listarEnderecoPorIdPessoa(Integer idPessoa) throws RegraDeNegocioException {

        if (pessoaExiste(idPessoa)) {
            return enderecoRepository.listarEnderecoPorIdPessoa(idPessoa).stream()
                    .map(this::convertToEnderecoDTO)
                    .collect(Collectors.toList());
        }
        throw new RegraDeNegocioException("A pessoa solicitada nao existe");
    }

    public EnderecoDTO criar(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        boolean pessoaExiste = enderecoRepository.listar().stream()
                .anyMatch(pessoa -> pessoa.getIdPessoa().equals(idPessoa));
        if (pessoaExiste) {
            EnderecoDTO enderecoDTO = convertToEnderecoDTO(enderecoRepository.criar(idPessoa, endereco));

            String tipoMensagem = MessageType.CREATE.getTipoDeMensagem();
            emailService.sendEmail(enderecoDTO, tipoMensagem);
            log.info("Enviando email... CREATE");

            return enderecoDTO;
        } else throw new RegraDeNegocioException("O endereco nao eh valido ou nao esta na lista.");
    }

    public EnderecoDTO editar(Integer idEndereco, EnderecoCreateDTO enderecoNovo) throws RegraDeNegocioException {
        if (endExiste(idEndereco)) {
            EnderecoDTO enderecoDTO = convertToEnderecoDTO(enderecoRepository.editar(idEndereco, enderecoNovo));

            String tipoMensagem = MessageType.UPDATE.getTipoDeMensagem();
            emailService.sendEmail(enderecoDTO, tipoMensagem);
            log.info("Enviando email... UPDATE");

            return enderecoDTO;
        } else throw new RegraDeNegocioException("O endereco nao esta na lista");
    }

    public void apagar(Integer idEndereco) throws RegraDeNegocioException {
        if (endExiste(idEndereco)) {
            Endereco endRemover = enderecoRepository.listar().stream()
                    .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                    .findFirst().get();
            EnderecoDTO enderecoDTO = convertToEnderecoDTO(endRemover);

            String tipoMensagem = MessageType.DELETE.getTipoDeMensagem();
            emailService.sendEmail(enderecoDTO, tipoMensagem);
            log.info("Enviando email... DELETE");

            enderecoRepository.apagar(idEndereco);
        }
    }
}
