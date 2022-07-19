package br.com.vemser.pessoaapi.enums;

import java.util.Arrays;

public enum MessageType {
    CREATE("create"),
    UPDATE("update"),
    DELETE("delete");

    private String tipoDeMensagem;

    MessageType(String tipoDeMensagem) {
        this.tipoDeMensagem = tipoDeMensagem;
    }

    public static MessageType tipo (String tipoMensagem){
        return Arrays.stream(MessageType.values())
                .filter(tp -> tp.getTipoDeMensagem().equals(tipoMensagem))
                .findFirst()
                .get();
    }

    public String getTipoDeMensagem() {
        return tipoDeMensagem;
    }
}
