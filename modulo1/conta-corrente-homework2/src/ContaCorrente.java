public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;

//    public double getChequeEspecial() {
//        return chequeEspecial;
//    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public double retornarSaldoComChequeEspecial(){
        return super.getSaldo() + this.chequeEspecial;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: ");
        getCliente().imprimirCliente();
        System.out.println("Numero da conta: "+getNumeroConta());
        System.out.println("Agencia: "+getAgencia());
        System.out.println("Saldo: "+getSaldo());
        System.out.println("Saldo cheque especial: "+this.chequeEspecial);
    }

//    implementar o sacar com override pq vou precisar faazer com q ele mude p usar o valor do cheque especial
}
