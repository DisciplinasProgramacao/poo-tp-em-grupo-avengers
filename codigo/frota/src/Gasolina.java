public class Gasolina implements ICombustivel {
    private double consumo = 10;
    private double preco = 5.19;

    @Override
    public double precoMedio() {
        return preco;
    }

    @Override
    public double consumoMedio() {
        return consumo;
    }
}