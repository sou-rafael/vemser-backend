public class Subtracao implements OperacaoMatematica{
    public int calcular(double a, double b){
        double c = a*b;
        int d = (int) c;
        return d;
    }
    @Override
    public int calcular(int a, int b){
        return a-b;
    }
}
