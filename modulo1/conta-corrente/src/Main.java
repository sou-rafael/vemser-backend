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

        clienteA.enderecos[0] = new Endereco();
        clienteA.enderecos[0].logradouro = "rua abandonada";
        clienteA.enderecos[0].numero = 12;
        clienteA.enderecos[0].cep = "64001-000";
        clienteA.enderecos[0].cidade = "Teresina";
        clienteA.enderecos[0].estado = "Piaui";
        clienteA.enderecos[0].pais = "Brasil";

        clienteA.enderecos[1] = new Endereco();
        clienteA.enderecos[1].logradouro = "rua casa da praia";
        clienteA.enderecos[1].numero = 1000;
        clienteA.enderecos[1].cep = "64005-000";
        clienteA.enderecos[1].cidade = "Cajueiro da Praia";
        clienteA.enderecos[1].estado = "Piaui";
        clienteA.enderecos[1].pais = "Brasil";

        clienteA.contatos[0] = new Contato();
        clienteA.contatos[0].descricao = "num pessoal - ligar so dps das 11h";
        clienteA.contatos[0].telefone = "86 99887-7334";
        clienteA.contatos[0].tipo = 1;

        clienteA.contatos[1] = new Contato();
        clienteA.contatos[1].descricao = "falar com secretaria";
        clienteA.contatos[1].telefone = "86 97558-6647";
        clienteA.contatos[1].tipo = 2;

        System.out.println("----------------------------------");
        clienteA.imprimirCliente();
        System.out.println("----------------------------------");
        clienteA.imprimirEnderecos();
        System.out.println("----------------------------------");
        clienteA.imprimirContatos();
        System.out.println("----------------------------------");



        Cliente clienteB = new Cliente();
        clienteB.nome = "Fabio Junior";
        clienteB.cpf = "456.456.456-80";

        clienteB.enderecos[0] = new Endereco();
        clienteB.enderecos[0].logradouro = "rua doze";
        clienteB.enderecos[0].numero = 245;
        clienteB.enderecos[0].cep = "64001-012";
        clienteB.enderecos[0].cidade = "Luis Correia";
        clienteB.enderecos[0].estado = "Piaui";
        clienteB.enderecos[0].pais = "Brasil";

        clienteB.enderecos[1] = new Endereco();
        clienteB.enderecos[1].logradouro = "rua beira do mar";
        clienteB.enderecos[1].numero = 20;
        clienteB.enderecos[1].cep = "64005-000";
        clienteB.enderecos[1].cidade = "Cajueiro da Praia";
        clienteB.enderecos[1].estado = "Piaui";
        clienteB.enderecos[1].pais = "Brasil";

        clienteB.contatos[0] = new Contato();
        clienteB.contatos[0].descricao = "num pessoal";
        clienteB.contatos[0].telefone = "86 99812-7345";
        clienteB.contatos[0].tipo = 1;

        clienteB.contatos[1] = new Contato();
        clienteB.contatos[1].descricao = "para show";
        clienteB.contatos[1].telefone = "86 97558-6647";
        clienteB.contatos[1].tipo = 2;

        System.out.println("----------------------------------");
        clienteB.imprimirCliente();
        System.out.println("----------------------------------");
        clienteB.imprimirEnderecos();
        System.out.println("----------------------------------");
        clienteB.imprimirContatos();

//      instanciando ContaCorrente

        ContaCorrente ccClienteA = new ContaCorrente();
        ccClienteA.cliente = clienteA;
        ccClienteA.numeroConta = "1234";
        ccClienteA.agencia = 9;
        ccClienteA.saldo = 2000;
        ccClienteA.chequeEspecial = 500;

        ContaCorrente ccClienteB = new ContaCorrente();
        ccClienteB.cliente = clienteB;
        ccClienteB.numeroConta = "5678";
        ccClienteB.agencia = 6;
        ccClienteB.saldo = 2000;
        ccClienteB.chequeEspecial = 300;

        System.out.println("----------------------------------");
        System.out.println("Imprimir conta-corrente:");
        ccClienteA.imprimirContaCorrente(); // teste de imprimir conta corrente
        ccClienteB.imprimirContaCorrente();
        System.out.println("----------------------------------");

        System.out.println("Saldo com Cheque Especial clienteA = "+ccClienteA.retornarSaldoComChequeEspecial());
        System.out.println("Saldo com Cheque Especial clienteB = "+ccClienteB.retornarSaldoComChequeEspecial());


        System.out.println("----------------------------------");
        System.out.println("Validacao para saque = "+ccClienteA.sacar(5000));

        System.out.println("----------------------------------");
        //operações
        System.out.println("Validacao para deposito valor negativo = \n"+ccClienteA.depositar(-500));

        System.out.println("Validacao para transferencia R$ 1000 A para B = \n"+ ccClienteA.transferir(ccClienteB, 1000));
        System.out.println("Validacao para transferencia R$ 20 B para A = \n"+ ccClienteA.transferir(ccClienteB, 20));
        System.out.println("----------------------------------");
//        opreaçoes usando o limite do cheque especial, mas sem alterar seu valor;
        System.out.println("NOVO saldo com Cheque Especial clienteA = "+ccClienteA.retornarSaldoComChequeEspecial());
        System.out.println("NOVO saldo com Cheque Especial clienteB = "+ccClienteB.retornarSaldoComChequeEspecial());
        System.out.println("ClienteA quer sacar R$ 1500: "+ccClienteA.sacar(1500));
        System.out.println("ClienteB quer sacar e entrar no cheque especial R$ 3320: "+ccClienteB.sacar(3320));


        System.out.println("----------------------------------");
        System.out.println("Conferindo novos saldos:");
        System.out.println("ClienteA: "+ ccClienteA.saldo);
        System.out.println("ClienteB: "+ ccClienteB.saldo);


    }
}
