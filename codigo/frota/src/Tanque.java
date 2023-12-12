import java.util.ArrayList;
import java.util.List;

public class Tanque {

    private double consumo; 
    private double capacidadeMax; 
    private double capacidadeAtual; 
    private double totalReabastecido; // Total de litros reabastecidos desde a criação do tanque
    private static ICombustivel combustivel; // Tipo de combustível associado ao tanque

    /**
     * Construtor da classe Tanque
     * @param capacidadeMax capacidade máxima do tanque
     * @param consumo
     */
    public Tanque(double capacidadeMax, double consumo, String tipoCombustivel) {
        this.capacidadeMax = capacidadeMax;
        this.consumo = consumo;

        // Verifica o tipo de combustível fornecido e instancia o objeto correspondente
        if (tipoCombustivel.equals("diesel")) {
            this.combustivel = new Diesel();
        } else if (tipoCombustivel.equals("gasolina")) {
            this.combustivel = new Gasolina();
        } else if (tipoCombustivel.equals("alcool")) {
            this.combustivel = new Alcool();
        }
    }

    /**
     * Abastece o tanque com uma quantidade especifica de litros.
     * @param litros quantidade que foi abstecido.
     */
    public double abastecer(double litros) {
        if (capacidadeAtual + litros <= capacidadeMax) {
            capacidadeAtual += litros;
            totalReabastecido += litros;
            return litros;
        } else {
            // Se a capacidade atual mais os litros ultrapassarem a capacidade máxima, não é possível abastecer tudo
            return 0;
        }
    }

    // Método que retorna a autonomia máxima do veículo com o tanque cheio
    public double autonomiaMaxima() {
        return combustivel.consumoMedio() * capacidadeMax;
    }

    // Método que retorna a autonomia atual do veículo com o combustível atual no tanque
    public double autonomiaAtual() {
        return combustivel.consumoMedio() * capacidadeAtual;
    }

    // Método estático que retorna o consumo médio do combustível associado ao tanque
    public static double getConsumo() {
        return combustivel.consumoMedio();
    }

    // Métodos para obter a capacidade máxima e a capacidade atual do tanque
    public double getCapacidadeMax() {
        return capacidadeMax;
    }
    public double getCapacidadeAtual() {
        return capacidadeAtual;
    }
}
