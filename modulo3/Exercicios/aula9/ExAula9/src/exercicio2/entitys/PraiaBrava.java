package exercicio2.entitys;

public class PraiaBrava extends Praia{
    private int quantidadeDeOndasPorMinuto;

    public PraiaBrava() {
    }

    public PraiaBrava(int quantidadeDeOndasPorMinuto) {
        this.quantidadeDeOndasPorMinuto = quantidadeDeOndasPorMinuto;
    }

    public int getQuantidadeDeOndasPorMinuto() {
        return quantidadeDeOndasPorMinuto;
    }

    public void setQuantidadeDeOndasPorMinuto(int quantidadeDeOndasPorMinuto) {
        this.quantidadeDeOndasPorMinuto = quantidadeDeOndasPorMinuto;
    }

    @Override
    public String toString() {
        return "Nome = "+ super.getNome() +
                "\nExtensao = "+ super.getExtensao()+
                "\nquantidadeDeOndasPorMinuto=" + this.quantidadeDeOndasPorMinuto;
    }
}
