import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Furgao extends Veiculo{

    private static String veiculo = "Furgao";
    private static final int MAX_ROTAS = 30;
    protected static final int CAPACIDADE_TANQUE = 60;
    private double totalReabastecido;
    private int quantRotas;
    private List<Rota> rotas;
    private double consumo;
    private String placa;
    private double despesaTotal;

    public Furgao(String placa, String tipoCombustivel) {
        super(placa, veiculo, tipoCombustivel);
        this.placa = placa;
        this.rotas = new ArrayList<>();
        this.quantRotas = 0;
    }
    
    public boolean addRota(Rota rota) {
        if (quantRotas < MAX_ROTAS && autonomiaMaxima() >= rota.getQuilometragem()) {
            rotas.add(rota);
            quantRotas++;
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

    public double kmTotal() {
        double quilometragemTotal = 0;
        for (Rota rota : rotas) {
            quilometragemTotal += Rota.getQuilometragem();
        }
        return quilometragemTotal;
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
            LocalDate dataRota = LocalDate.parse(Rota.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    
            if (dataRota.getMonth().equals(dataAtual.getMonth()) && dataRota.getYear() == dataAtual.getYear()) {
                kmNoMes += Rota.getQuilometragem();
            }
        }
        return kmNoMes;
    }
    

    /**
     * Método que calcula o valor da autonomia atual do carro
     * @return valor 
     */
    public double getAutonomiaAtual() {
        return kmTotal() / totalReabastecido;
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
