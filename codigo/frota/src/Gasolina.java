public class Gasolina implements ICombustivel{
	private double consumo = 10;
	private double preco = 5.19;
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