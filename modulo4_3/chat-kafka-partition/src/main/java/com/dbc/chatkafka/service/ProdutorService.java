package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.MensagemCreateDTO;
import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.enums.EnvioEnum;
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
    private String topico;

    @Value("${kafka.user}")
    private String usuario;

    public void enviarMensagemGeral(MensagemCreateDTO mensagemCreateDTO, Integer particao) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        enviarMensagem(mensagemDTO, topico, particao);
    }

    public void enviarMensagemPrivadoEspecifico(MensagemCreateDTO mensagemCreateDTO, EnvioEnum envioEnum) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());

        enviarMensagem(mensagemDTO, topico, envioEnum.ordinal());
    }

    public void enviarMensagemPrivadoLista(MensagemCreateDTO mensagemCreateDTO, List<EnvioEnum> listaEnumUsuario) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.convertValue(mensagemCreateDTO, MensagemDTO.class);
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());
        for (EnvioEnum usuario :
                listaEnumUsuario) {
            enviarMensagem(mensagemDTO, topico, usuario.ordinal());
        }

    }


    // ENVIANDO PARA TOPICO
    private void enviarMensagem(MensagemDTO mensagemDTO, String topico, Integer particao) throws JsonProcessingException {
        String mensagemString = objectMapper.writeValueAsString(mensagemDTO);
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagemString)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.PARTITION_ID, particao);

        Message<String> stringMessage = stringMessageBuilder
                .build();

        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(stringMessage);
        send.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult result) {
                log.info(" Mensagem enviada!");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao enviar a msg!");
            }
        });
    }
}
