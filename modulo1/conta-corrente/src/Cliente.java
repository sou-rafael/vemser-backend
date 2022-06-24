public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirCliente(){
        System.out.println(this);
        imprimirContatos();
        imprimirEnderecos();
    }

    public void imprimirContatos() {
        System.out.println("Listando os contatos");
        for (int i = 0; i < contatos.length; i++) {
            if(contatos[i] != null) {
                System.out.println(contatos[i]);
            }
        }
    }

    public void imprimirEnderecos() {
        System.out.println("Listando os enderecos");
        for (Endereco elem: this.enderecos) {
            if(elem != null) {
                System.out.println(elem);
            }
        }
    }
@Override
    public String toString() {
        return "Nome= "+nome+", CPF= "+ cpf;
}

}
