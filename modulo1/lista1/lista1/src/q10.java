import java.util.Scanner;

public class q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double eleitores, brancos, nulos, validos, percBrancos, percNulos, percValidos;

        System.out.println("Digite o numero de eleitores:");
        eleitores = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o numero de votos em branco:");
        brancos = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o numero de votos nulos:");
        nulos = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o numero de votos validos:");
        validos = sc.nextDouble();
        sc.nextLine();

        percBrancos = (brancos/eleitores)*100;
        percNulos = (nulos/eleitores)*100;
        percValidos = (validos/eleitores)*100;

        System.out.println("Percentagem de votos brancos = "+percBrancos+" %");
        System.out.println("Percentagem de votos nulos = "+percNulos+" %");
        System.out.println("Percentagem de votos validos = "+percValidos+" %");

    }
}

