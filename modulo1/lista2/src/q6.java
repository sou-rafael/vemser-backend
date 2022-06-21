import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] vetor = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Qual numero vc quer procurar?");
        int alvo = sc.nextInt();
        sc.nextLine();
        sc.close();

//        Buscar a posição do numero alvo

        int indiceAlvo = 0;

        for(int i = 0; i < vetor.length; i++) {
            if (vetor[i] == alvo) {
                indiceAlvo = i;
            }
        }
        if(vetor[indiceAlvo]==alvo) {
            System.out.println("O numero " + alvo + " esta na posicao " + indiceAlvo);

        }else{
            System.out.println("O numero " + alvo + " nao existe neste vetor.");
        }
    }
}
