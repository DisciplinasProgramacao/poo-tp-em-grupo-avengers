public class Tanque {
    /*Consumo médio do veículo em litros por quilometros */
    private static final double CONSUMO = 8.2;
    
    private double capacidadeMaxima;
    private double capacidadeAtual;
    private double totalReabastecido;
    private String tipoVeiculo;
    private String combustível;
    
    /**
     * Construtor da classe Tanque
     * @param capacidadeMaxima capacidade máxima do tanque
     * @param capacidadeAtual capacidade inicial do tanque
     */
    public Tanque(double capacidadeMaxima, double capacidadeAtual, String tipoVeiculo, String combustível) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
        this.tipoVeiculo = tipoVeiculo;
        this.combustível = combustível;
    }
    
    public Tanque(String modelo, double capacidadeAtual2) {
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
        double consumo = getConsumoMedioCombustivel();
        return capacidadeAtual * consumo;
    }

    public double getConsumoMedioCombustivel() {
        switch (combustível) {
            case "álcool":
                return 7;
            case "gasolina":
                return 10;
            case "diesel":
                return 4;
            default:
                throw new IllegalArgumentException("Combustível inválido");
        }
    }
    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getCombustível() {
        return combustível;
    }

    public double getManutençãoPrevista() {
        switch (tipoVeiculo) {
            case "carro":
                return 10000;
            case "van":
                return 10000;
            case "furgão":
                return 12000;
            case "caminhão":
                return 20000;
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido");
        }
    }

    public double getManutençãoPrevistaPeças() {
        switch (tipoVeiculo) {
            case "carro":
                return 10000;
            case "van":
                return 12000;
            case "furgão":
                return 12000;
            case "caminhão":
                return 20000;
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido");
        }
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
