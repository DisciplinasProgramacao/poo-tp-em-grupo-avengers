class Tanque {

    private ICombustivel combustivel;
    private double consumo;
    private double capacidadeMax;
    private double capacidadeAtual;
    private double totalReabastecido;

    public Tanque(double capacidadeMax, double consumo, String combustivel, Double preco) {
        this.combustivel = getCombustivel(combustivel, preco);
        this.capacidadeMax = capacidadeMax;
        this.consumo = consumo;
        this.capacidadeAtual = capacidadeMax;
        this.totalReabastecido = 0;
    }

    private ICombustivel getCombustivel(String combustivel, Double preco) {
        if (combustivel.equals("álcool")) {
            return new Alcool();
        } else if (combustivel.equals("gasolina")) {
            return new Gasolina();
        } else if (combustivel.equals("diesel")) {
            return new Diesel();
        } else {
            throw new IllegalArgumentException("Combustivel inválido");
        }
    }

    public double abastecer(double litros) {
        if (litros <= 0) {
            throw new IllegalArgumentException("Quantidade de litros inválida");
        }

        if (capacidadeAtual + litros > capacidadeMax) {
            litros = capacidadeMax - capacidadeAtual;
        }
        double valor = litros * combustivel.precoMedio(litros);
        capacidadeAtual += litros;
        totalReabastecido += litros;

        return valor;
    }

    public double autonomiaMaxima() {
        return capacidadeMax / consumo;
    }

    public double autonomiaAtual() {
        return capacidadeAtual / consumo;
    }

    public static double getConsumo() {
        return Tanque.getConsumo();
    }

}