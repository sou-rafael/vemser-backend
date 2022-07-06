package Exerc3;

public class Gato extends Animal{
    public String mia(){
        return "Miau Miau Miau";
    }

    public Gato() {
    }

    public Gato(String nome, String raca) {
        super(nome, raca);
    }

}
