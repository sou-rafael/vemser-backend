package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.MensagemCreateDTO;
import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.enums.TopicoUsuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Value("${kafka.topic}")
    private String topicoGeral;

    @Value("${kafka.user}")
    private String usuario;
    @Value("${kafka.topic-rafael}")
    private String topicoRafael;

    public void enviarMensagemGeral(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        enviarMensagem(mensagemDTO, topicoGeral);
    }

    public void enviarMensagemPrivado(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        enviarMensagem(mensagemDTO, topicoRafael);
    }

    public void enviarMensagemPrivadoEspecifico(MensagemCreateDTO mensagemCreateDTO, TopicoUsuario usuarioTopico) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        enviarMensagem(mensagemDTO, usuarioTopico.getUsuario());
    }

    public void enviarMensagemPrivadoLista(MensagemCreateDTO mensagemCreateDTO, List<TopicoUsuario> listaEnumUsuario) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        for (TopicoUsuario usuario :
                listaEnumUsuario) {
            enviarMensagem(mensagemDTO, usuario.getUsuario());
        }

    }

    private void enviarMensagem(MensagemDTO mensagemDTO, String topico) throws JsonProcessingException {
        String mensagemString = objectMapper.writeValueAsString(mensagemDTO);

        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagemString)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        Message<String> stringMessage = stringMessageBuilder
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessage);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", mensagemString);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", mensagemString, ex);
            }
        });
    }
}
