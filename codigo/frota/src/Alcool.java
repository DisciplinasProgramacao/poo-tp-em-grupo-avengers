public class Alcool implements ICombustivel {
    private double consumo = 7;
    private double preco = 3.29;

    @Override
    public double precoMedio() {
        return preco;
    }

    @Override
    public double consumoMedio() {
        return consumo;
    }
}