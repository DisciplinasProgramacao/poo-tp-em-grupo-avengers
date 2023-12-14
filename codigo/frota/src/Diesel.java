public class Diesel implements ICombustivel {
    private double consumo = 4;
    private double preco = 6.09;

    @Override
    public double precoMedio() {
        return preco;
    }

    @Override
    public double consumoMedio() {
        return consumo;
    }
}