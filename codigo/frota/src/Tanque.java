public class Tanque {
    /*Consumo médio do veículo em litros por quilometros */
    private static final double CONSUMO = 8.2;
    
    private double capacidadeMaxima;
    private double capacidadeAtual;
    private double totalReabastecido;
    
    /**
     * Construtor da classe Tanque
     * @param capacidadeMaxima capacidade máxima do tanque
     * @param capacidadeAtual capacidade inicial do tanque
     */
    public Tanque(double capacidadeMaxima, double capacidadeAtual) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
        this.totalReabastecido = 0;
    }
    
    /**
     * Abastece o tanque com uma quantidade especifica de litros.
     * @param litros quantidade a ser abastecida.
     * @return A quantidade de litros efetivamente abastecidos, considerando a capacidade do tanque.
     */
    public double abastecer(double litros) {
        if (litros >= 0) {
            double litrosAbastecidos = capacidadeMaxima - capacidadeAtual; 
            if (litrosAbastecidos > litros) {
                litrosAbastecidos = litros; 
            }
            capacidadeAtual += litrosAbastecidos;
            this.totalReabastecido += litrosAbastecidos;
            return litrosAbastecidos; 
        } else {
            return 0.0; // Retorna 0 se litros for negativo
        }
    }    
    /**
     * Calcula a autonomia máxima com o combustível atual.
     * @return autonomia máxima que o veículo pode percorrer em km
     */
    public double autonomiaMaxima() {
        return capacidadeAtual * CONSUMO;
    }
    
    /**
     * Calcula a autonomia atual com o combustível atual.
     * @return autonomia atual que o veículo pode percorrer em km
     */
    public double autonomiaAtual() {
        return capacidadeAtual * CONSUMO;
    }

    //Gets and Sets

    /**
     * Obtém o valor da capacidade atual do carro
     * @return capacidade atual do tanque
     */
    public double getCapacidadeAtual() {
        return capacidadeAtual;
    }

    /**
     * Obtém o valor da capacidade máxima do carro
     * @return valor da capacidade máxima
     */
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     * Obtém o total de litros reabastecidos desde a criação do tanque.
     * @return total de litros
     */
    public double getTotalReabastecido(){
        return this.totalReabastecido;
    }

}
