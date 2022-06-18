import java.util.Scanner;
public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha um estado:");
        System.out.println("1 - PIAUI");
        System.out.println("2 - CEARA");
        System.out.println("3 - MARANHAO");

        int est = sc.nextInt();
        sc.nextLine();

        switch (est){
            case 1:
                System.out.println("Estado do PIAUI");
                System.out.println("Escolha uma cidade:");
                System.out.println("1 - TERESINA");
                System.out.println("2 - PARNAIBA");
                int cid = sc.nextInt();
                sc.nextLine();

                switch (cid){
                    case 1:
                        System.out.println("Cidade TERESINA - PI");
                        System.out.println("Populacao(2010): 814.230 pessoas");
                        System.out.println("PIB per capita(2019): R$ 25.458,50");
                        System.out.println("Aniversario: 16 de agosto");
                        break;

                    case 2:
                        System.out.println("Cidade PARNAIBA - PI");
                        System.out.println("Populacao(2010): 145.705 pessoas");
                        System.out.println("PIB per capita(2019): R$ 17.163,13");
                        System.out.println("Aniversario: 14 de Agosto");
                        break;
                    default:
                        System.out.println("Cidade invalida");
            }
            break;


            case 2:
                System.out.println("Estado do CEARA");
                System.out.println("Escolha uma cidade:");
                System.out.println("1 - FORTALEZA");
                System.out.println("2 - SOBRAL");
                cid = sc.nextInt();
                sc.nextLine();

                switch (cid){
                    case 1:
                        System.out.println("Cidade FORTALEZA - CE");
                        System.out.println("Populacao(2010): 2.452.185 pessoas");
                        System.out.println("PIB per capita(2019): R$ 25.254,44");
                        System.out.println("Aniversario: 13 de Abril");
                        break;

                    case 2:
                        System.out.println("Cidade SOBRAL - CE");
                        System.out.println("Populacao(2010): 188.233 pessoas");
                        System.out.println("PIB per capita(2019): R$ 21.919,49");
                        System.out.println("Aniversario: 5 de Julho");
                        break;
                    default:
                        System.out.println("Cidade invalida");
                }
                break;

            case 3:
                System.out.println("Estado do MARANHAO");
                System.out.println("Escolha uma cidade:");
                System.out.println("1 - SAO LUIS");
                System.out.println("2 - TIMON");
                cid = sc.nextInt();
                sc.nextLine();

                switch (cid){
                    case 1:
                        System.out.println("Cidade SAO LUIS - MA");
                        System.out.println("Populacao(2010): 1.014.837 pessoas");
                        System.out.println("PIB per capita(2019): R$ 29.135,32");
                        System.out.println("Aniversario: 8 de Setembro");
                        break;

                    case 2:
                        System.out.println("Cidade TIMON - MA");
                        System.out.println("Populacao(2010): 155.460 pessoas");
                        System.out.println("PIB per capita(2019): R$ 11.229,91");
                        System.out.println("Aniversario: 22 de Dezembro");
                        break;
                    default:
                        System.out.println("Cidade invalida");
                    break;

                }
                break;

            default:
                System.out.println("Estado inválido");
        }


    }
}
