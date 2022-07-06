public class Main{

    public static void main(String[] args) {
       Calculo calcular = new Calculo(){
           @Override
           public int soma(int valor1, int valor2) {
               return valor1 + valor2;
           }

           @Override
           public int multiplicacao(int valor1, int valor2) {
               return valor1 * valor2;
           }
       };
        System.out.println(calcular.soma(2,1));
        System.out.println(calcular.multiplicacao(3,4));
    }

}
