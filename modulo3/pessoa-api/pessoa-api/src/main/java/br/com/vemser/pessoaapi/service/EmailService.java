package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailService {
    @Value("${spring.mail.username}")
    private String meuEmail;
    private JavaMailSender emailSender;

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


}
