public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public double getChequeEspecial() {
        return chequeEspecial;
    }

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
    public String toString() {
        return "ContaCorrente{" +
                "cliente=" + super.getCliente() +
                ", numeroConta='" + super.getNumeroConta() +
                ", agencia=" + super.getAgencia() +
                ", saldo=" + super.getSaldo() +
                ", chequeEspecial=" + this.chequeEspecial +
                '}';
    }
}
