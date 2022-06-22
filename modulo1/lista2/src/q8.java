import java.util.Scanner;

public class q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        double[][] notas = {{100, 8, 2, 0},{200,7,1,0},{300,8,4,0},{400,5,6,0},{500,9,6,0}};

        double[][] notas = new double[2][4];

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Aluno " + (i + 1));

            System.out.println("Numero da Matricula: ");
            notas[i][0] = sc.nextInt();
            sc.nextLine();

            System.out.println("Media das Provas: ");
            notas[i][1] = sc.nextInt();
            sc.nextLine();

            System.out.println("Media dos Trabalhos: ");
            notas[i][2] = sc.nextInt();
            sc.nextLine();

            double somaNF = notas[i][1] + notas[i][2];
            notas[i][3] = somaNF;
//                System.out.println("Nota Final: ");

        }

        // ler as 3 primeiras informações e ja calcular a nota final
        System.out.println("*****************************************\nExibindo as 3 primeiras informacoes:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println(notas[i][0] + " | " + notas[i][1] + " | " + notas[i][2]);
            notas[i][3] = notas[i][1] * 0.6 + notas[i][2] * 0.4;
        }
        System.out.println("****************************************");

        // media da notas finais
        double somaNFTotal = 0;
        for (double[] elem : notas) {
            somaNFTotal += elem[3];
        }
        double mediaNF = somaNFTotal / notas.length;
        System.out.println("Media das notas finais " + mediaNF);

            // Buscar a matricula de maior nota final

            double maior = 0;
            int indiceMaior = -1;
            for (int i = 0; i < notas.length; i++) {
                if (notas[i][3] > maior) {
                    maior = notas[i][3];
                    indiceMaior = i;
                }
            }
            System.out.println("Maior nota eh " + maior + ", na matricula " + notas[indiceMaior][0]);

        }
    }
