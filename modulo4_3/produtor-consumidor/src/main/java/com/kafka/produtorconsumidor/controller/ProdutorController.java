package com.kafka.produtorconsumidor.controller;


import com.kafka.produtorconsumidor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviarMensagemParaOTopico(String mensagem){
        produtorService.enviarMensagemKafka(mensagem);
    }
}
