public class Contato {
    private String descricao = "";
    private String telefone = "";
    private int tipo = 0; // 1-residencial , 2-comercial

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato(){
        System.out.println("Descricao: "+descricao+"\nTelefone: "+telefone+"\nTipo: "+tipo);

    }
//    metodo construtor sem parametros e com eles
    public Contato(){

    }
    public Contato(String descricao, String telefone, int tipo){
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Descricao='" + descricao +", telefone= " + telefone +", tipo=" + tipo;
    }
}
