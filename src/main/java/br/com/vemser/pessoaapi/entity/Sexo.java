package br.com.vemser.pessoaapi.entity;

public enum Sexo {
    M("masculino"),
    F("feminino");

    private String sexo;

    Sexo(String sexo){
        this.sexo = sexo;
    }
    public String getSexo(){
        return sexo;
    }
}
