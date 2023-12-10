import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
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

    //Métodos Getters e Setters
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public int getPortas() {
        return portas;
    }

    public void setTotalReabastecido(double totalReabastecido) {
        this.totalReabastecido = totalReabastecido;
    }

    public double getTotalReabastecido() {
        return totalReabastecido;
    }

    public void setQuantRotas(int quantRotas) {
        this.quantRotas = quantRotas;
    }

    public void setRotas(Rota[] rotas) {
        this.rotas = rotas;
    }

    public int getQuantRotas() {
        return quantRotas;
    }

    public List<Rota> getRotas() {
        return rotas;
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

    public double KmTotal() {
        double kmTotal = 0.0;
        for (int i = 0; i < quantRotas; i++) {
            kmTotal += rotas[i].getDistancia();
        }
        return kmTotal;
    }

    /**
     * Calcula a quilometragem rodada pelo carro naquele mes de acordo com a data atual do sistema 
     * @return valor da quilometragem por mês
     */
    public double KmNoMes() {
    if (quantRotas == 0) {
        return 0.0; // Não há rotas registradas, então não há quilômetros no mês
    }
    LocalDate dataAtual = LocalDate.now();
    double kmNoMes = 0.0;
    for (int i = 0; i < quantRotas; i++) {
        LocalDate dataRota = LocalDate.parse(rotas[i].getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dataRota.getMonth().equals(dataAtual.getMonth()) && dataRota.getYear() == dataAtual.getYear()) {
            kmNoMes += rotas[i].getQuilometragem();
        }
    }
    return kmNoMes;
}
    /**
     * Retorna o valor de abastecimento do carro
     */
    public double abastecer(double litros) {
        double valor = litros * preçoLitro;
        totalReabastecido += litros;
        return valor;
    }

    /**
     * Método que calcula o valor da autonomia atual do carro
     * @return valor 
     */
    public double getAutonomiaAtual() {
        return KmTotal() / totalReabastecido;
    }

    /**
     * Calcula autonomia máxima de consumo do carro
     * @return valor 
     */
    public double getAutonomiaMaxima() {
        return 100.0 / consumo;
    }

    public void fazerManutencao(double valor) {
        despesaTotal += valor;
    }

    /**
     * Método de rotorno do valor de despesa total do carro
     * @return valor da despesa total
     */
    public double getDespesaTotal() {
        return despesaTotal;
    }
}