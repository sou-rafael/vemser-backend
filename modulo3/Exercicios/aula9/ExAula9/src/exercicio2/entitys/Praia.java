package exercicio2.entitys;

public abstract class Praia {
    private int extensao;
    private String nome;

    public Praia(int extensao, String nome) {
        this.extensao = extensao;
        this.nome = nome;
    }

    public Praia() {
    }

    public int getExtensao() {
        return extensao;
    }

    public void setExtensao(int extensao) {
        this.extensao = extensao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
