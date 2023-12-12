public class Alcool implements ICombustivel{
	private double consumo = 7;
	private double preco = 3.29;
    @Override
    public double precoMedio() {
        double valor = this.preco;
        return valor;
    }
    @Override
    public double consumoMedio() {
        double valor = this.consumo;
        return valor;
    }
}