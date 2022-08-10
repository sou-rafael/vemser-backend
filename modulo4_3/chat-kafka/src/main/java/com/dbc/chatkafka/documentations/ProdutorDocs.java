package com.dbc.chatkafka.documentations;

import com.dbc.chatkafka.annotations.ProdutorNotas;
import com.dbc.chatkafka.dto.MensagemCreateDTO;
import com.dbc.chatkafka.enums.TopicoUsuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProdutorDocs {
    @ProdutorNotas
    @Operation(summary = "Enviar uma mensagem para o grupo geral.", description = "Envia uma mensagem para o grupo geral.")
    public void enviarMensagemGeral(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException;

    @ProdutorNotas
    @Operation(summary = "Enviar uma mensagem para o usuário setado.", description = "Envia uma mensagem para um usuario predefinido(inalteravel).")
    public void enviarMensagemPrivado(MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException;

    @ProdutorNotas
    @Operation(summary = "Enviar uma mensagem para um usuário especifico.", description = "Envia uma mensagem para um usuario único, escolhido de uma lista.")
    public void enviarMensagemEspecifico(@PathVariable("usuario") TopicoUsuario usuario, MensagemCreateDTO mensagemCreateDTO) throws JsonProcessingException;

    @ProdutorNotas
    @Operation(summary = "Enviar uma mensagem para vários usuários.", description = "Envia uma mensagem para varios usuários ao mesmo tempo. Os usuarios devem ser escolhidos clicando com ctrl.")
    public void enviarMensagemPrivadoLista(MensagemCreateDTO mensagemCreateDTO, @RequestParam List<TopicoUsuario> listaEnumUsuarios) throws JsonProcessingException;
}
