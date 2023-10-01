public class Tanque {
    private static final double CONSUMO = 8.2;
    
    private double capacidadeMaxima;
    private double capacidadeAtual;
    private double totalReabastecido;
    
    public Tanque(double capacidadeMaxima, double capacidadeAtual) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.capacidadeAtual = capacidadeAtual;
        this.totalReabastecido = 0;
    }
    
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
    
    public double autonomiaMaxima() {
        return capacidadeAtual * CONSUMO;
    }
    
    public double autonomiaAtual() {
        return capacidadeAtual * CONSUMO;
    }

    //Gets and Sets

    public double getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public double getTotalReabastecido(){
        return this.totalReabastecido;
    }

}
