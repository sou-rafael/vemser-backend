package enums;

public enum Pedido {
    JAPONESA("Comida Japonesa"),
    FAST_FOOD("Comida Fast Food"),
    TRADICIONAL("Comida Tradicional");
    private String descricao;
    Pedido(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
