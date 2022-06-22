import java.util.Scanner;

public class q7 {
    public static void main(String[] args) {
//        int[][] matriz = {{0,1,2,3}, {10,11,12,13}, {20,21,22,23}, {30,31,32,33}};
        int cont = 0;
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][4];

//        Criar a lista de valores
        for(int i = 0; i<= matriz.length-1; i++) {
            for(int j = 0; j <= matriz.length-1; j++) {
                System.out.println("Insira o valor na linha "+i+", coluna "+j);
                matriz[i][j] = sc.nextInt();
                sc.nextLine();
            }
        }

//         matriz [i][j]
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                if(matriz[i][j] > 10){
                    cont++;
                }
            }
        }
        System.out.println("A matriz possui "+cont+" numeros maiores que 10.");
    }
}
