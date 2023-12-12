import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Furgao extends Veiculo{

    private double totalReabastecido;
    private int quantRotas;
    private Rota[] rotas;
    private double consumo;
    private int MAX_ROTAS;

    public Furgao(String placa, double capacidadeTanque, double capacidadeAtual) {
        super(placa, capacidadeTanque, capacidadeAtual);
        //TODO Auto-generated constructor stub
        capacidadeTanque = 60;
        this.placa = placa;
        this.rotas = new ArrayList<>();
        this.quantRotas = 0;
    }
    
    public boolean addRota(Rota rota) {
        if (quantRotas < MAX_ROTAS && autonomiaMaxima() >= rota.getQuilometragem()) {
            rotas[quantRotas++] = rota;
            return true;
        }
        return false;
    }

    public void percorrerRota(Rota rota) {
        double distancia = rota.getQuilometragem();
        double litros = distancia / consumo;
        totalReabastecido += litros;
        quantRotas++;
    }

    public double KmTotal() {
        double kmTotal = 0.0;
        for (int i = 0; i < quantRotas; i++) {
            kmTotal += rotas[i].getQuilometragem();
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
