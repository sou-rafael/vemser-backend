import java.util.Scanner;
public class q1 {
    public static void main(String[] args) {
        String nome;
        Double valor;
        double[] valDesc = new double[10];


        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o NOME do produto");
        nome = sc.nextLine();

        System.out.println("Informe o VALOR do produto");
        valor = sc.nextDouble();
        sc.nextLine();
        sc.close();

//        Criar a lista dos descontos com o incremento do percentual de 0.05 ao fim de cada iteração
        double percent = 0.05;
        for(int i = 0; i <= 9; i++){
            valDesc[i] = valor - (valor*percent);
            percent += 0.05;
        }
        System.out.println("Produto: "+nome);
        System.out.println("Preco R$: "+valor);
        System.out.println("Promocao: "+nome);
        System.out.println("----------------------");
//        Iterar sobre a lista de descontos fazendo os calculos e imprimindo
        int cont = 0;
        for(double elem:valDesc){
            System.out.println((cont+1)+" x R$ "+elem+" = R$ "+(elem*(cont+1)));
            cont++;
        }

    }
}
