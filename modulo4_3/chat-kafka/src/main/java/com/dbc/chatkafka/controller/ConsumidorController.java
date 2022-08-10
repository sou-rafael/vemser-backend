package com.dbc.chatkafka.controller;

import com.dbc.chatkafka.documentations.ConsumidorDocs;
import com.dbc.chatkafka.service.ConsumidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/novidades")
@RequiredArgsConstructor
public class ConsumidorController implements ConsumidorDocs {
    private final ConsumidorService consumidorService;

    @GetMapping("/rafael")
    public List<String> retornarNovidadesRafael() {
        return consumidorService.novidadesRafael;
    }

    @GetMapping("/geral")
    public List<String> retornarNovidadesGeral() {
        return consumidorService.novidadesGeral;
    }

    @DeleteMapping("/apagar-mensagens-rafael")
    public void apagarMensagensRafael() {
        consumidorService.novidadesRafael.clear();
    }

    @DeleteMapping("/apagar-mais-antiga-rafael")
    public String apagarMaisAntigaRafael() {
        consumidorService.novidadesRafael.remove(0);
        return "A mensagem mais antiga foi apagada!";
    }

}
