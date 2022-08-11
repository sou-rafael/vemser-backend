package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
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

    @Value("${kafka.topic}")
    private String topico;

    @KafkaListener(
            topics = "${kafka.topic}", // chat-kafka-partition
            groupId = "${kafka.group-id}", // rafael
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})},
            containerFactory = "listenerContainerFactory"
    )
    public void consumirChatGeral(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);

        String msgFormatada = formatarData(mensagemDTO.getDataCriacao()) + " [" + mensagemDTO.getUsuario().toUpperCase() + "]: " + mensagemDTO.getMensagem();

        System.out.println(msgFormatada);
    }


    @KafkaListener(
            topics = "${kafka.topic}", // chat-kafka-partition
            groupId = "${kafka.group-id}", // rafael
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"12"})},
            containerFactory = "listenerContainerFactory"
    )
    public void consumirChatRafael(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);

        String msgFormatada = formatarData(mensagemDTO.getDataCriacao()) + " [" + mensagemDTO.getUsuario().toUpperCase() + "] (private): " + mensagemDTO.getMensagem();

        System.out.println(msgFormatada);
    }

    private String formatarData(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }

}
