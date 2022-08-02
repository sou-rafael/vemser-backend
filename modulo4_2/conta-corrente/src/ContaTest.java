import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {
    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        //variaveis
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int saque = 1500;

        //act
        boolean conseguiuSacar = contaCorrente.sacar(saque);

        //asserts
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(-500, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        // variaveis
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        contaCorrente.setChequeEspecial(1000);
        int saque = 2500;
        //act
        boolean conseguiuSacar = contaCorrente.sacar(saque);

        //assert
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        //variaveis
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);
        contaPoupanca.creditarTaxa(); //taxa creditada

        int saque = 800;

        //act
        boolean conseguiuSacar = contaPoupanca.sacar(saque);

        //asserts
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(210, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        //variaveis
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000);
        contaPoupanca.creditarTaxa();
        int saque = 1200;

        //act
        boolean conseguiuSacar = contaPoupanca.sacar(saque);

        //asserts
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1010, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        // variaveis
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000.0);
        double saque = 500.0;
        //act
        boolean conseguiuSacar = contaPagamento.sacar(saque);

        //assert
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(495.75, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        //variaveis
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000);
        int saque = 1000;

        //act
        boolean conseguiuSacar = contaPagamento.sacar(saque);

        //asserts
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000, contaPagamento.getSaldo());
    }

    //   =======================================================================
//                     TESTANDO CONTA-CORRENTE
//   =======================================================================
    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        //variaveis
        ContaCorrente contaCorrenteA = new ContaCorrente();
        ContaCorrente contaCorrenteB = new ContaCorrente();

        contaCorrenteA.setSaldo(500.0);
        contaCorrenteA.setChequeEspecial(200.0);

        contaCorrenteB.setSaldo(500.0);
        contaCorrenteB.setChequeEspecial(200.0);

        double transferencia = 500.0;

        //act
        boolean conseguiuTransferir = contaCorrenteA.transferir(contaCorrenteB, transferencia);

        //asserts
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(0.0, contaCorrenteA.getSaldo());
        Assertions.assertEquals(1000.0, contaCorrenteB.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        //variaveis
        ContaCorrente contaCorrenteA = new ContaCorrente();
        ContaCorrente contaCorrenteB = new ContaCorrente();

        contaCorrenteA.setSaldo(800.0);
        contaCorrenteA.setChequeEspecial(200.0);

        contaCorrenteB.setSaldo(800.0);
        contaCorrenteB.setChequeEspecial(200.0);

        double transferencia = 1100.0;

        //act
        boolean conseguiuTransferir = contaCorrenteA.transferir(contaCorrenteB, transferencia);

        //asserts
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(800.0, contaCorrenteA.getSaldo());
        Assertions.assertEquals(800.0, contaCorrenteB.getSaldo());
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {
        //variaveis
        ContaCorrente contaCorrenteA = new ContaCorrente();
        contaCorrenteA.setSaldo(500);
        contaCorrenteA.setChequeEspecial(200);
        int deposito = 100;

        //act
        boolean conseguiuTransferir = contaCorrenteA.depositar(deposito);

        //asserts
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(600, contaCorrenteA.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativo() {
        //variaveis
        ContaCorrente contaCorrenteA = new ContaCorrente();
        contaCorrenteA.setSaldo(500);
        contaCorrenteA.setChequeEspecial(200);
        int deposito = -100;

        //act
        boolean conseguiuTransferir = contaCorrenteA.depositar(deposito);

        //asserts
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(500, contaCorrenteA.getSaldo());
    }

    //   =======================================================================
//                     TESTANDO POUPANÇA
//   =======================================================================
    @Test
    public void deveTestarTransferenciaParaPoupancaEVerificarSaldoComSucesso() {
        //variaveis
        ContaPoupanca contaPoupancaA = new ContaPoupanca();
        ContaPoupanca contaPoupancaB = new ContaPoupanca();

        contaPoupancaA.setSaldo(500.0);
        contaPoupancaB.setSaldo(500.0);

        double transferencia = 200.0;

        //act
        boolean conseguiuTransferir = contaPoupancaA.transferir(contaPoupancaB, transferencia);

        //asserts
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(300.0, contaPoupancaA.getSaldo());
        Assertions.assertEquals(700.0, contaPoupancaB.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaParaPoupancaSemSaldo() {
        //variaveis
        ContaPoupanca contaPoupancaA = new ContaPoupanca();
        ContaPoupanca contaPoupancaB = new ContaPoupanca();

        contaPoupancaA.setSaldo(800.0);

        contaPoupancaB.setSaldo(800.0);

        double transferencia = 1100.0;

        //act
        boolean conseguiuTransferir = contaPoupancaA.transferir(contaPoupancaB, transferencia);

        //asserts
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(800.0, contaPoupancaA.getSaldo());
        Assertions.assertEquals(800.0, contaPoupancaB.getSaldo());
    }

    @Test
    public void deveTestarDepositoParaPoupancaEVerificarSaldoComSucesso() {
        //variaveis
        ContaPoupanca contaPoupancaA = new ContaPoupanca();
        contaPoupancaA.setSaldo(500);
        int deposito = 100;

        //act
        boolean conseguiuTransferir = contaPoupancaA.depositar(deposito);

        //asserts
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(600, contaPoupancaA.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativoParaPoupanca() {
        //variaveis
        ContaPoupanca contaPoupancaA = new ContaPoupanca();
        contaPoupancaA.setSaldo(500);
        int deposito = -100;

        //act
        boolean conseguiuTransferir = contaPoupancaA.depositar(deposito);

        //asserts
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(500, contaPoupancaA.getSaldo());
    }

    //   =======================================================================
//                     TESTANDO CONTA-PAGAMENTO
//   =======================================================================
    @Test
    public void deveTestarTransferenciaParaContaPagamentoEVerificarSaldoComSucesso() {
        //variaveis
        ContaPagamento contaPagamentoA = new ContaPagamento();
        ContaPagamento contaPagamentoB = new ContaPagamento();

        contaPagamentoA.setSaldo(500.0);
        contaPagamentoB.setSaldo(500.0);

        double transferencia = 200.0;

        //act
        boolean conseguiuTransferir = contaPagamentoA.transferir(contaPagamentoB, transferencia);

        //asserts
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(300, contaPagamentoA.getSaldo());
        Assertions.assertEquals(700.0, contaPagamentoB.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaParaContaPagamentoSemSaldo() {
        //variaveis
        ContaPagamento contaPagamentoA = new ContaPagamento();
        ContaPagamento contaPagamentoB = new ContaPagamento();

        contaPagamentoA.setSaldo(800.0);

        contaPagamentoB.setSaldo(800.0);

        double transferencia = 1100.0;

        //act
        boolean conseguiuTransferir = contaPagamentoA.transferir(contaPagamentoB, transferencia);

        //asserts
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(800.0, contaPagamentoA.getSaldo());
        Assertions.assertEquals(800.0, contaPagamentoB.getSaldo());
    }

    @Test
    public void deveTestarDepositoParaContaPagamentoEVerificarSaldoComSucesso() {
        //variaveis
        ContaPagamento contaPagamentoA = new ContaPagamento();
        contaPagamentoA.setSaldo(500);
        int deposito = 100;

        //act
        boolean conseguiuTransferir = contaPagamentoA.depositar(deposito);

        //asserts
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(600, contaPagamentoA.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativoParaContaPagamento() {
        //variaveis
        ContaPagamento contaPagamentoA = new ContaPagamento();
        contaPagamentoA.setSaldo(500);
        int deposito = -100;

        //act
        boolean conseguiuTransferir = contaPagamentoA.depositar(deposito);

        //asserts
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(500, contaPagamentoA.getSaldo());
    }
}
