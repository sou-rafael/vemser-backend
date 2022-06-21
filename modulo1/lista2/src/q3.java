import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantJog = 5;
        String quit = "SAIR";
        String[][] jogadores = new String[quantJog][4];

        // nome - altura - idade - peso
        for (int i = 0; i < jogadores.length; i++) {
            do {
                System.out.println("Jogador " + (i + 1));

                System.out.println("Nome: ");
                jogadores[i][0] = sc.nextLine();

                System.out.println("Altura: ");
                jogadores[i][1] = sc.nextLine();

                System.out.println("Idade: ");
                jogadores[i][2] = sc.nextLine();

                System.out.println("Peso: ");
                jogadores[i][3] = sc.nextLine();

            } while (!jogadores[i][0].equalsIgnoreCase(quit));
        }
    }
}
