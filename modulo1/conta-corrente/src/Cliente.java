public class Cliente {
    String nome = "";
    String cpf = "";
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos() {
        System.out.println("Listando os contatos");
        contatos[0] = new Contato();
        contatos[1] = new Contato();
        for (int i = 0; i < contatos.length; i++) {
            System.out.println(contatos[i]);
        }
    }

    public void imprimirEnderecos() {
        System.out.println("Listando os enderecos");
        for (Endereco elem: this.enderecos) {
            System.out.println(elem);
        }
    }

    public void imprimirCliente(){
        System.out.println("Nome: "+nome+"\nCPF: "+cpf);
    }

}
