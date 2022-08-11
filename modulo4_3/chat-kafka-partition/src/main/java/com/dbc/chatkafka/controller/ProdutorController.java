package com.dbc.chatkafka.controller;


import com.dbc.chatkafka.documentations.ProdutorDocs;
import com.dbc.chatkafka.dto.MensagemCreateDTO;
import com.dbc.chatkafka.enums.EnvioEnum;
import com.dbc.chatkafka.enums.TopicoUsuario;
import com.dbc.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat-kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar-geral")
    public void enviarMensagemGeral(@RequestBody MensagemCreateDTO mensagemCreateDTO, Integer particao) throws JsonProcessingException {
        produtorService.enviarMensagemGeral(mensagemCreateDTO, particao);
    }

//    @PostMapping("/enviar-rafael")
//    public void enviarMensagemPrivado(@RequestBody MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
//        produtorService.enviarMensagemPrivado(mensagemCreateDTO);
//    }
//
    @PostMapping("/enviar/{usuario}")
    public void enviarMensagemEspecifico(@PathVariable("usuario") EnvioEnum envioEnum, @RequestBody MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException {
        produtorService.enviarMensagemPrivadoEspecifico(mensagemCreateDTO, envioEnum);
    }

    @PostMapping("/enviar-lista")
    public void enviarMensagemPrivadoLista(@RequestBody MensagemCreateDTO mensagemCreateDTO, @RequestParam List<EnvioEnum> listaEnumUsuarios) throws JsonProcessingException {
        produtorService.enviarMensagemPrivadoLista(mensagemCreateDTO, listaEnumUsuarios);
    }
}
