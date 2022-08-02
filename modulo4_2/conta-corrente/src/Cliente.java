import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    ArrayList<Contato> contatos; // não precisa instanciar a ArrayList dentro da Cliente
    ArrayList<Endereco> enderecos;

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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }


    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirCliente() {
        System.out.println("Nome: " + this.nome + "\nCpf: " + this.cpf);
    }

    public void imprimirContatos() {
        if (contatos != null) {
            for (int i = 0; i < contatos.size(); i++) {
                contatos.get(i).imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        if (enderecos != null) {
            for (int i = 0; i < enderecos.size(); i++) {
                enderecos.get(i).imprimirEndereco();
            }
        }
    }
}
