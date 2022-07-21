package br.com.vemser.pessoaapi.enums;

import java.util.Arrays;

public enum TipoPet {
    CACHORRO(0),
    GATO(1),
    GUAXINIM(2);

    private Integer tipo;

    TipoPet(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoPet ofTipo(Integer tipo){
        return Arrays.stream(TipoPet.values())
                .filter(tipoPet -> tipoPet.getTipo().equals(tipo))
                .findFirst().get();
    }
}
