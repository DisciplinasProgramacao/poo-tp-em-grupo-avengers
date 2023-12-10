import java.util.Arrays;
import java.util.List;

public class Carro extends Veiculo {
    private String categoria;
    private int portas;
    private double totalReabastecido;
    private int quantRotas;
    private Rota[] rotas;
    private double consumo;
    private int MAX_ROTAS;
    private double preçoLitro;

    public Carro(String placa, double modelo, double consumo, String categoria, int portas) {
        super(placa, modelo, consumo);
        this.categoria = categoria;
        this.portas = portas;
        this.totalReabastecido = 0.0;
        this.quantRotas = 0;
        this.rotas = new Rota[MAX_ROTAS];
    }

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", consumo=" + consumo +
                ", categoria='" + categoria + '\'' +
                ", portas=" + portas +
                ", totalReabastecido=" + totalReabastecido +
                ", quantRotas=" + quantRotas +
                ", rotas=" + Arrays.toString(rotas) +
                '}';
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public double getTotalReabastecido() {
        return totalReabastecido;
    }

    public void setTotalReabastecido(double totalReabastecido) {
        this.totalReabastecido = totalReabastecido;
    }

    public int getQuantRotas() {
        return quantRotas;
    }

    public void setQuantRotas(int quantRotas) {
        this.quantRotas = quantRotas;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(Rota[] rotas) {
        this.rotas = rotas;
    }

    public boolean addRota(Rota rota) {
        if (quantRotas < MAX_ROTAS) {
            rotas[quantRotas++] = rota;
            return true;
        }
        return false;
    }

    public void percorrerRota(Rota rota) {
        double distancia = rota.getDistancia();
        double litros = distancia / consumo;
        totalReabastecido += litros;
        quantRotas++;
    }

    public double getKmTotal() {
        double kmTotal = 0.0;
        for (Rota rota : rotas) {
            kmTotal += rota.getDistancia();
        }
        return kmTotal;
    }

    public double getKmNoMes() {
        return getKmTotal() / (System.currentTimeMillis() / (3600 * 24 * 30));
    }

    public double abastecer(double litros) {
        double valor = litros * preçoLitro;
        totalReabastecido += litros;
        return valor;
    }

    public double getAutonomiaAtual() {
        return getKmTotal() / totalReabastecido;
    }

    public double getAutonomiaMaxima() {
        return 100.0 / consumo;
    }

    public void fazerManutencao(double valor) {
        despesaTotal += valor;
    }

    public double getDespesaTotal() {
        return despesaTotal;
    }
}