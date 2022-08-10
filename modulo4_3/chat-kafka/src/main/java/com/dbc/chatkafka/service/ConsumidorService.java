package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final ObjectMapper objectMapper;

    public List<String> novidadesGeral = new ArrayList<>();
    public List<String> novidadesRafael = new ArrayList<>();

    @KafkaListener(
            topics = "${kafka.topic}", // chat-geral
            groupId = "${kafka.group-id}", // rafael
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "geral")
    public void consumirChatGeral(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);

        String msgFormatada = formatarData(mensagemDTO.getDataCriacao()) + " [" + mensagemDTO.getUsuario().toUpperCase() + "]: " + mensagemDTO.getMensagem();

        novidadesGeral.add(msgFormatada);

        System.out.println(formatarData(mensagemDTO.getDataCriacao()) + " [" + mensagemDTO.getUsuario().toUpperCase() + "]: " + mensagemDTO.getMensagem());
    }

    @KafkaListener(
            topics = "${kafka.topic-rafael}", // chat-rafael
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "rafael")
    public void consumirChatRafael(@Payload String mensagem,
                                   @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                   @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);

        String msgFormatada = formatarData(mensagemDTO.getDataCriacao()) + " [" + mensagemDTO.getUsuario().toUpperCase() + "] (privada): " + mensagemDTO.getMensagem();

        novidadesRafael.add(msgFormatada); //ponto de enviar p MongoDB

        System.out.println(msgFormatada);

    }

    private String formatarData(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }
}
