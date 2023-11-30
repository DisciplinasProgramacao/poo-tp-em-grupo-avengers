import java.util.ArrayList;
import java.util.List;

public class Caminhao {
    private static final int MAX_ROTAS = 30;
    private static final double CONSUMO = 4;
    
    private String placa;
    private List<Rota> rotas;
    int quantRotas;
    private double tanqueAtual;
    private double tanqueMax;	
    private double totalReabastecido;
    private Tanque tanque;
    private String tipoTanque = "diesel";
    private double kilometragem; 
    private double consumoTotal;
    private double valorDiesel = 6.09;
    private double manutencaoProg = 20.000;
    private double fezManutencao = 0;
    private double kmManutencao = 0;
    private double despesa;
    
    public Caminhao(String placa, double capacidadeTanque, double capacidadeAtual) {
    	capacidadeTanque = 250;
        this.placa = placa;
        this.rotas = new ArrayList<>();
        this.quantRotas = 0;
        this.tanque = new Tanque(capacidadeTanque, capacidadeAtual);
    }
    
    public boolean addRota(Rota rota) {
        if (quantRotas < MAX_ROTAS && autonomiaMaxima() >= rota.getQuilometragem()) {
            rotas.add(rota);
            quantRotas++;
            return true;
        }
        return false;
    }
