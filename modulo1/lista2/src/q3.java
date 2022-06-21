import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = "", nomeMaisVelho = "", nomeMaisPesado = "";
        float altura = 0.0f, maiorAltura = 0.0f, somaAltura = 0.0f, mediaAltura = 0.0f, peso, maiorPeso = 0.0f;
        int cont = 0, idade, maiorIdade = 0;

        while(true){
            cont++;
            System.out.println("Nome:");
            nome = sc.nextLine();
            if(nome.equalsIgnoreCase("SAIR")) {
                break;
            }

            System.out.println("Insira a altura:");
            altura = sc.nextFloat();
            sc.nextLine();
            somaAltura = somaAltura + altura;
            if(altura > maiorAltura){
                maiorAltura = altura;
            }

            System.out.println("Idade:");
            idade = sc.nextInt();
            sc.nextLine();
            if(idade > maiorIdade){
                maiorIdade = idade;
                nomeMaisVelho = nome;
            }

            System.out.println("Peso");
            peso = sc.nextFloat();
            sc.nextLine();
            if(peso > maiorPeso){
                maiorPeso = peso;
                nomeMaisPesado = nome;
            }

        }
        mediaAltura = somaAltura/cont;
        System.out.println("Quantidade de jogadores: "+(cont-1));
        System.out.println("Altura do maior jogador eh"+maiorAltura);
        System.out.println("O jogador mais velho eh "+nomeMaisVelho+" com "+maiorIdade+" anos.");
        System.out.println("O jogador mais pesado eh "+nomeMaisPesado+" com "+maiorPeso+" kilos.");



    }
}