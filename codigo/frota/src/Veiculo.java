

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Veiculo {
    private String placa;
    private String tipoVeiculo;
    private Map<String, Rota> rotas;
    private Tanque tanque;
    private int quantRotas;
    private Map<LocalDate, Integer> rotasPorMes;

    public Veiculo(String placa, String tipoVeiculo, Tanque tanque) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.rotas = new HashMap<>();
        this.tanque = tanque;
        this.rotasPorMes = new HashMap<>();
        this.quantRotas = 0;
    }

    public boolean addRota(String idRota, Rota rota) {
        LocalDate mesAtual = LocalDate.now().withDayOfMonth(1); // Obtém o mês atual
        rotasPorMes.putIfAbsent(mesAtual, 0); // Inicializa o contador para o mês se não existir

        int rotasNoMes = rotasPorMes.get(mesAtual);
        if (rotasNoMes >= 30) {
            System.out.println("Limite de rotas mensais atingido para o veículo " + placa);
            return false; // Retorna false se o limite for alcançado ou não possui combustivel o suficiente
        }

        rotasNoMes++;
        rotasPorMes.put(mesAtual, rotasNoMes);
        rotas.put(idRota, rota);
        return true;
    }

    public void limparRotasNoInicioDoMes() {
        LocalDate mesAtual = LocalDate.now().withDayOfMonth(1); // Obtém o mês atual
        LocalDate mesPassado = mesAtual.minusMonths(1); // Obtém o mês passado

        rotasPorMes.remove(mesPassado); // Remove as rotas do mês passado
    }

    public String relatorioRotas() {
        StringBuilder relatorio = new StringBuilder("Relatório de Rotas do Veículo " + placa + ":\n");
        for (Map.Entry<String, Rota> entry : rotas.entrySet()) {
            String idRota = entry.getKey();
            Rota rota = entry.getValue();
            relatorio.append("ID da Rota: ").append(idRota).append(", Quilometragem: ").append(rota.getQuilometragem()).append(", Data: ").append(rota.getData()).append("\n");
        }
        return relatorio.toString();
    }
    
    
    public double KmNoMes() {
        if (rotas.isEmpty()) {
            return 0.0; // Não há rotas registradas, então não há quilômetros no mês
        }
    
        LocalDate dataAtual = LocalDate.now();
        double kmNoMes = 0.0;
    
        for (Map.Entry<String, Rota> entry : rotas.entrySet()) {
            Rota rota = entry.getValue();
    
            if (rota.getData().getMonth().equals(dataAtual.getMonth()) && rota.getData().getYear() == dataAtual.getYear()) {
                kmNoMes += rota.getQuilometragem();
            }
        }
        return kmNoMes;
    }
    
    

    public double kmTotal() {
        return rotas.values().stream().mapToDouble(Rota::getQuilometragem).sum();
    }

    public boolean percorrerRota(Rota rota) {
        double distancia = rota.getQuilometragem();
        double consumoVeiculo = this.tanque.getConsumo();

        if (tanque.autonomiaMaxima() >= distancia) {
            double quantidadeCombustivel = distancia / consumoVeiculo;
            this.tanque.setTanqueAtual(this.tanque.getTanqueAtual() - quantidadeCombustivel);
            rotas.put(rota.getId(), rota);
            this.quantRotas++;
            return true;
        }
        return false;
    }

    public void realizarManutencao(Veiculo veiculo, double quilometragem) {
        Manutencao.fazerManutencao(veiculo, quilometragem);
    }

    public double calcularDespesaTotal() {
        return tanque.getTotalReabastecido() + Manutencao.getValorManutenao();
    }

   //Gets and Setters
   public Map<String, Rota> getRotas() {
    return rotas;
}
   
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public Object getTipoVeiculo() {
        return tipoVeiculo;
    }

    public int getQuantRotas() {
        return quantRotas;
    }
}
