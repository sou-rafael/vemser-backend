package com.dbc.chatkafka.enums;

public enum TopicoUsuario {
    RAFAEL("chat-rafael"),
    DAYVIDSON("chat-dayvidson"),
    CESAR("chat-cesar"),
    JEAN("chat-jean"),
    MATEUS_CASTRO("chat-castro"),
    CLEBER("chat-cleber"),
    GABRIEL("chat-gabriel"),
    PAULO("chat-paulo"),
    BRUNO("chat-bruno"),
    MATEUS_MACHADO("chat-machado"),
    WILLIAN("chat-willian"),
    RODRIGO("chat-rodrigo")
    ;

    private String usuario;
    TopicoUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getUsuario() {
        return usuario;
    }
}
