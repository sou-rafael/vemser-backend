package Exerc3;

public class Main {
    public static void main(String[] args) {
        Gato cat = new Gato("mijuca","pelado");
        Cachorro dog = new Cachorro();

        System.out.println(cat.caminha());
        System.out.println(cat.mia());
        System.out.println(dog.late());

        dog.setNome("tsunami");
        dog.setRaca("labrador");

        System.out.println(dog);
        System.out.println(cat.toString());
    }
}
