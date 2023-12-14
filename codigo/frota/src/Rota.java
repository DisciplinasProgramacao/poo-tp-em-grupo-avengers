import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Rota {
    private String id;
    private Map<String, Double> rota; // Usando um Map para armazenar os quilômetros por localização
    private LocalDate data; // Data da rota

    public Rota(String id) {
        this.id = id;
        this.rota = new HashMap<>();
        this.data = LocalDate.now(); // Data atual ao criar a rota
    }

    public void addRota(String localizacao, double quilometros) {
        rota.put(localizacao, quilometros);
    }
    
    public void relatorio() {
        System.out.println("Relatório da Rota " + id + ":");
        for (Map.Entry<String, Double> entry : rota.entrySet()) {
            System.out.println("Localização: " + entry.getKey() + ", Quilômetros: " + entry.getValue());
        }
    }

    public double getQuilometragem() {
        // Somando os quilômetros percorridos em todas as localizações da rota
        return rota.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public LocalDate getData() {
        return data;
    }
    
    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Double> getRota() {
        return rota;
    }

    public void setRota(Map<String, Double> rota) {
        this.rota = rota;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
