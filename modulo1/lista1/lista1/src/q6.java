import java.util.Scanner;
public class q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Traduzir:" +"\n1 - ingles -> portugues"+"\n2 - portugues -> ingles");
        int idioma = sc.nextInt();
        sc.nextLine();

        switch (idioma){
            case 1:
                System.out.println("Digite a palavra em ingles e toda minuscula:");
                String palavra = sc.nextLine();
                switch (palavra){
                    case "dog":
                        System.out.println("Cachorro");
                        break;
                    case "time":
                        System.out.println("Tempo");
                        break;
                    case "love":
                        System.out.println("Amor");
                        break;
                    case "city":
                        System.out.println("Cidade");
                        break;
                    case "happy":
                        System.out.println("Feliz");
                        break;
                    case "sad":
                        System.out.println("Triste");
                        break;
                    case "shoud":
                        System.out.println("Deveria");
                        break;
                    case "could":
                        System.out.println("Poderia");
                        break;
                    default:
                        System.out.println("Essa palavra nao eh valida.");
                }
                break;
            case 2:
                System.out.println("Digite a palavra em portugues e toda minuscula:");
                palavra = sc.nextLine();
                switch (palavra){
                    case "cachorro":
                        System.out.println("Dog");
                        break;
                    case "tempo":
                        System.out.println("Time");
                        break;
                    case "amor":
                        System.out.println("Love");
                        break;
                    case "cidade":
                        System.out.println("City");
                        break;
                    case "feliz":
                        System.out.println("Happy");
                        break;
                    case "triste":
                        System.out.println("Sad");
                        break;
                    case "deveria":
                        System.out.println("Shoud");
                        break;
                    case "poderia":
                        System.out.println("Could");
                        break;
                    default:
                        System.out.println("Essa palavra nao eh valida.");
                }
                break;
        }
    }
}
