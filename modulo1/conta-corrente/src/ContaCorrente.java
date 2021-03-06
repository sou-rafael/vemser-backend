public class ContaCorrente {
    Cliente cliente;
    String numeroConta = "";
    int agencia = 0;
    double saldo = 0;
    double chequeEspecial = 0;

    public void imprimirContaCorrente(){
        System.out.println("Cliente: "+ cliente.nome);
        System.out.println("Numero da conta: "+numeroConta);
        System.out.println("Agencia: "+agencia);
        System.out.println("Saldo: "+saldo);
    }

    public boolean sacar(double valor){
        if(this.retornarSaldoComChequeEspecial() >= valor && valor > 0){
            this.saldo -= valor;
            return true;
        }else return false;
    }

    public boolean depositar(double valor){
        if(valor > 0) {
            saldo += valor;
            return true;
        }
        else return false;
    }

    public double retornarSaldoComChequeEspecial(){
        return this.saldo + this.chequeEspecial;
    }

    public boolean transferir(ContaCorrente outraCC, double valor){
        // transferir da minhaCC para outraCC que for passada por parametro
        if(this.retornarSaldoComChequeEspecial() > 0 && valor > 0){
            this.saldo -= valor;
            outraCC.saldo += valor;
            return true;
        }else return false;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "cliente=" + cliente +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }
}
