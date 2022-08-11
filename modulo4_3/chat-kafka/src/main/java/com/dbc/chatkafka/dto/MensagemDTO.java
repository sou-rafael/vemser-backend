package com.dbc.chatkafka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO {

    @Schema(hidden = true) // isso faz com que o atributo nao apareça no swagger
    private String usuario;

    private String mensagem;

    @Schema(hidden = true)
    private LocalDateTime dataCriacao;
}
