package com.dbc.chatkafka.documentations;

import com.dbc.chatkafka.annotations.ConsumidorNotas;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface ConsumidorDocs {
    @ConsumidorNotas
    @Operation(summary = "Listar as mensagens mais recentes de Rafael.", description = "Exibe uma lista formatada com as mensagens mais recentes do usuario Rafael")
    public List<String> retornarNovidadesRafael();

    @ConsumidorNotas
    @Operation(summary = "Listar mensagens mais recentes do Geral.", description = "Exibe uma lista formatada com as mensagens mais recentes do grupo geral.")
    public List<String> retornarNovidadesGeral();

    @ConsumidorNotas
    @Operation(summary = "Limpar da memoria todas as mensagens de Rafael.", description = "Apaga da memória local todas as mensagens do usuario Rafael.")
    public void apagarMensagensRafael();

    @ConsumidorNotas
    @Operation(summary = "Limpar da memoria a mensagem mais antiga de Rafael.", description = "Apaga da memória local a mensagem mais antiga do usuario Rafael.")
    public String apagarMaisAntigaRafael();
}
