public class Main {
// TESTAR TODAS A OPERAÇÕES DE CONTACORRENTE
//    o teste deve ter pelo menos 2 clientes com suas CC
//    1 transferencia entre eles
//    ao final imprimir as duas contas

//    criando os CLIENTES:
    public static void main(String[] args) {
        Cliente clienteA = new Cliente();
        clienteA.nome = "Raimundo Soldado";
        clienteA.cpf = "123.123.123-90";

//        //************ NPE ******************

//        clienteA.enderecos[0].logradouro = "rua abandonada";
//        clienteA.enderecos[0].numero = 12;
//        clienteA.enderecos[0].cep = "64001-000";
//        clienteA.enderecos[0].cidade = "Teresina";
//        clienteA.enderecos[0].estado = "Piaui";
//        clienteA.enderecos[0].pais = "Brasil";
//
//        clienteA.enderecos[1].logradouro = "rua casa da praia";
//        clienteA.enderecos[1].numero = 1000;
//        clienteA.enderecos[1].cep = "64005-000";
//        clienteA.enderecos[1].cidade = "Cajueiro da Praia";
//        clienteA.enderecos[1].estado = "Piaui";
//        clienteA.enderecos[1].pais = "Brasil";
//
//        clienteA.contatos[0].descricao = "num pessoal - ligar só dps das 11h";
//        clienteA.contatos[0].telefone = "86 99887-7334";
//        clienteA.contatos[0].tipo = 1;
//
//        clienteA.contatos[0].descricao = "falar com secretaria";
//        clienteA.contatos[0].telefone = "86 97558-6647";
//        clienteA.contatos[0].tipo = 2;
//
        clienteA.imprimirCliente();
//        clienteA.imprimirEnderecos();
//        clienteA.imprimirContatos();

        Cliente clienteB = new Cliente();
        clienteB.nome = "Fabio Junior";
        clienteB.cpf = "456.456.456-80";

        ContaCorrente ccClienteA = new ContaCorrente();
        ccClienteA.cliente = clienteA;
        ccClienteA.numeroConta = "1234";
        ccClienteA.agencia = 9;
        ccClienteA.saldo = 12000;
        ccClienteA.chequeEspecial = 500;

        ContaCorrente ccClienteB = new ContaCorrente();
        ccClienteB.cliente = clienteB;
        ccClienteB.numeroConta = "5678";
        ccClienteB.agencia = 6;
        ccClienteB.saldo = 35000;
        ccClienteB.chequeEspecial = 1500;

        ccClienteA.imprimirContaCorrente(); // teste de imprimir conta corrente

        System.out.println("Saldo com Cheque Especial = "+ccClienteA.retornarSaldoComChequeEspecial());

        System.out.println("Validacao para saque = "+ccClienteA.sacar(5000));

        System.out.println("Validacao para deposito valor negativo = "+ccClienteA.depositar(-500));

        System.out.println("Validacao para trasnferencia = "+ ccClienteA.transferir(ccClienteB, 1000));
        System.out.println("Conferindo novos saldos:");
        System.out.println("ClienteA: "+ ccClienteA.saldo);
        System.out.println("ClienteB: "+ ccClienteB.saldo);


    }
}
