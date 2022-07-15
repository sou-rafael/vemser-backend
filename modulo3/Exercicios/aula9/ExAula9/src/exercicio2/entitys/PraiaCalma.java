package exercicio2.entitys;

public class PraiaCalma extends Praia{
    private boolean podeLevarAnimais;

    public PraiaCalma() {
    }

    public PraiaCalma(boolean podeLevarAnimais) {
        this.podeLevarAnimais = podeLevarAnimais;
    }

    public boolean isPodeLevarAnimais() {
        return podeLevarAnimais;
    }

    public void setPodeLevarAnimais(boolean podeLevarAnimais) {
        this.podeLevarAnimais = podeLevarAnimais;
    }

    @Override
    public String toString() {
        return "Nome = "+ super.getNome() +
                "\nExtensao = "+ super.getExtensao()+
                "\nPode levar animais = " + podeLevarAnimais;
    }
}
