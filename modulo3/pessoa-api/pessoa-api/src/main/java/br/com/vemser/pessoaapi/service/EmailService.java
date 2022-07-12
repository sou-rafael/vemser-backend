package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {
    @Value("${spring.mail.username}")
    private String meuEmail;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private PessoaRepository pessoaRepository;

    private final freemarker.template.Configuration fmConfiguration;

    public void sendPessoaCriada(PessoaDTO pessoa) {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        mensagem.setFrom(meuEmail);
        mensagem.setTo(pessoa.getEmail());
        mensagem.setSubject("Seja muito bem-vindo!");
        mensagem.setText(
                "Olá " + pessoa.getNome() + ",\n"
                        + "Estamos felizes em ter você em nosso sistema :)\n"
                        + "Seu cadastro foi realizado com sucesso, seu identificador é "
                        + pessoa.getIdPessoa() + ".\n"
                        + "Qualquer dúvida é só contatar o suporte pelo email "
                        + meuEmail
                        + "\nAtt,\nSistema."
        );
        emailSender.send(mensagem);
    }

    public void sendPessoaAlterada(PessoaDTO pessoa) {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        mensagem.setFrom(meuEmail);
        mensagem.setTo(pessoa.getEmail());
        mensagem.setSubject("Seus dados foram alterados com sucesso!");
        mensagem.setText(
                "Olá " + pessoa.getNome()
                        + ", \nSeus dados foram atualizados no nosso sistema."
                        + "\nQualquer duvida é só contatar o suporte pelo e-mail "
                        + meuEmail
                        + "\nAtt,\nSistema."
        );
        emailSender.send(mensagem);
    }

    public void sendPessoaExcluida(PessoaDTO pessoa) {
        SimpleMailMessage mensagem = new SimpleMailMessage();

        mensagem.setFrom(meuEmail);
        mensagem.setTo(pessoa.getEmail());
        mensagem.setSubject("Confirmação de exclusão");
        mensagem.setText(
                "Olá " + pessoa.getNome()
                        + ", \nVocê perdeu o acesso ao nosso sistema."
                        + "\nQualquer duvida é só contatar o suporte pelo e-mail "
                        + meuEmail
                        + "\nAtt,\nSistema."
        );
        emailSender.send(mensagem);
    }

    //******************** ENDERECO ***********************************
    public void sendEnderecoCriado(EnderecoDTO endereco) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        // pegar a pessoa dona do endereco pelo idPessoa
        Pessoa pessoa = pessoaRepository.listar().stream()
                .filter(pp -> pp.getIdPessoa().equals(endereco.getIdPessoa()))
                .findFirst().get();

        mensagem.setFrom(meuEmail);
        mensagem.setTo(pessoa.getEmail());
        mensagem.setSubject("Seja muito bem-vindo!");
        mensagem.setText(
                "Olá " + pessoa.getNome() + ",\n"
                        + "Um novo endereço foi inserido no seu perfil:\n"
                        + endereco.toString()
                        + "\nQualquer dúvida é só contatar o suporte pelo email "
                        + meuEmail
                        + "\nAtt,\nSistema."
        );
        emailSender.send(mensagem);
    }
    public String templateEnderecoCriado(EnderecoDTO enderecoDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("Endereco", enderecoDTO.toString());

        Template template = fmConfiguration.getTemplate("templateBasico.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendEnderecoAlterado(EnderecoDTO endereco) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        // pegar a pessoa dona do endereco pelo idPessoa
        Pessoa pessoa = pessoaRepository.listar().stream()
                .filter(pp -> pp.getIdPessoa().equals(endereco.getIdPessoa()))
                .findFirst().get();

        mensagem.setFrom(meuEmail);
        mensagem.setTo(pessoa.getEmail());
        mensagem.setSubject("Seja muito bem-vindo!");
        mensagem.setText(
                "Olá " + pessoa.getNome() + ",\n"
                        + "Um novo endereço foi inserido no seu perfil:\n"
                        + endereco.toString()
                        + "\nQualquer dúvida é só contatar o suporte pelo email "
                        + meuEmail
                        + "\nAtt,\nSistema."
        );
        emailSender.send(mensagem);
    }

    public void sendEnderecoDeletado(EnderecoDTO endereco) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        // pegar a pessoa dona do endereco pelo idPessoa
        Pessoa pessoa = pessoaRepository.listar().stream()
                .filter(pp -> pp.getIdPessoa().equals(endereco.getIdPessoa()))
                .findFirst().get();

        mensagem.setFrom(meuEmail);
        mensagem.setTo(pessoa.getEmail());
        mensagem.setSubject("Seja muito bem-vindo!");
        mensagem.setText(
                "Olá " + pessoa.getNome() + ",\n"
                        + "Este endereço foi excluido do seu perfil:\n"
                        + endereco.toString()
                        + "\nQualquer dúvida é só contatar o suporte pelo email "
                        + meuEmail
                        + "\nAtt,\nSistema."
        );
        emailSender.send(mensagem);
    }

    //    ***************** template *********************


}
