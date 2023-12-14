public class Diesel implements ICombustivel{
	private double consumo = 4;
	private double preco = 6.09;
    @Override
    public double precoMedio(double preco) {
        double valor = this.preco;
        return valor;
    }
    @Override
    public double consumoMedio() {
        double valor = this.consumo;
        return valor;
    }
}