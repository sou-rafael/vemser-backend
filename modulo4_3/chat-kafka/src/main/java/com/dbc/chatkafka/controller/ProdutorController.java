package com.dbc.chatkafka.controller;


import com.dbc.chatkafka.dto.MensagemCreateDTO;
import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/chat-kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar-geral")
    public void enviarMensagemGeral(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        produtorService.enviarMensagemGeral(mensagemCreateDTO);
    }

    @PostMapping("/enviar-rafael")
    public void enviarMensagemPrivado(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        produtorService.enviarMensagemPrivado(mensagemCreateDTO);
    }
    //TODO - passar o enum como @RequestParam
}
