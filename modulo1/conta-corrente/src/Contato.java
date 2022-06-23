public class Contato {
    String descricao = "";
    String telefone = "";
    int tipo = 0; // 1-residencial , 2-comercial

    public void imprimirContato(){
        System.out.println("Descricao: "+descricao+"\nTelefone: "+telefone+"\nTipo: "+tipo);

    }
    @Override
    public String toString() {
        return "Descricao='" + descricao +", telefone= " + telefone +", tipo=" + tipo;
    }
}
