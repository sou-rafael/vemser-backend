package com.dbc.chatkafka.controller;


import com.dbc.chatkafka.dto.MensagemCreateDTO;
import com.dbc.chatkafka.dto.MensagemDTO;
import com.dbc.chatkafka.enums.TopicoUsuario;
import com.dbc.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

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

    @PostMapping("/enviar/{usuario}")
    public void enviarMensagemEspecifico(@PathVariable("usuario") TopicoUsuario usuario, MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        produtorService.enviarMensagemPrivadoEspecifico(mensagemCreateDTO, usuario);
    }

    @PostMapping("/enviar-lista")
    public void enviarMensagemPrivadoLista(MensagemCreateDTO mensagemCreateDTO, @RequestParam List<TopicoUsuario> listaEnumUsuarios) throws JsonProcessingException {
        produtorService.enviarMensagemPrivadoLista(mensagemCreateDTO, listaEnumUsuarios);
    }
}
