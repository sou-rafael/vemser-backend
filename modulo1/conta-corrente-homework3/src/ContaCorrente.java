public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;


    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public double retornarSaldoComChequeEspecial(){
        return super.getSaldo() + this.chequeEspecial;
    }

    //TRANSFERIR PRECISA SER SOBRESCRITO PQ O METODO SACAR TEM UMA ESPECIFICIDADE QUE É O USO DO CHEQUE ESPECIAL
    @Override
    public boolean transferir(Conta conta, double valor) {
        if(this.retornarSaldoComChequeEspecial()>valor && valor>0){
            this.sacar(valor);
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial){
        this.setCliente(cliente);
        this.setNumeroConta(numeroConta);
        this.setAgencia(agencia);
        this.setSaldo(saldo);
        this.setChequeEspecial(chequeEspecial);
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

//    implementei o sacar com override
    @Override
    public boolean sacar(double valor){
        if(this.retornarSaldoComChequeEspecial() > valor && valor > 0){
            super.setSaldo(getSaldo()-valor);
            return true;
        }else return false;
    }
}
