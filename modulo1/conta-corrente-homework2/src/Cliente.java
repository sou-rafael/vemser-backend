public class Cliente{
    private String nome = "";
    private String cpf = "";
    private Contato[] contatos = new Contato[2];

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(int posicao, String contato) {
        if(posicao < this.contatos.length){
            this.contatos[posicao] = contato;
            this.contatos = contatos;
        }
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    private Endereco[] enderecos = new Endereco[2];

//    metodo construtor
    public Cliente(){

    }
    public void imprimirCliente(){
        System.out.println(this);
        imprimirContatos();
        imprimirEnderecos();
    }

    public void imprimirContatos() {
        System.out.println("Listando os contatos");
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
@Override
    public String toString() {
        return "Nome= "+nome+", CPF= "+ cpf;
}

}
