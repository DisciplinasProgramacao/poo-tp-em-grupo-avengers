

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private static final int MAX_ROTAS = 30;
    protected String placa;
    private List<Rota> rotas;
    int quantRotas;
    private double tanqueAtual;
    private double tanqueMax;
    private double totalReabastecido;
    private Tanque tanque;
    private Manutencao manutencao;
    
    public Veiculo(String placa, double capacidadeTanque, double capacidadeAtual) {
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
    
    public double autonomiaMaxima() {
        return tanqueAtual * CONSUMO;
    }
    
    public double autonomiaAtual() {
        return tanqueAtual * CONSUMO;
    }
    
    public double abastecer(double litros) {
        return tanque.abastecer(litros);
    }
    
    public double kmMes() {
        double quilometragemMes = 0;
        for (Rota rota : rotas) {
            quilometragemMes += rota.getQuilometragem();
        }
        return quilometragemMes;
    }
    
    public double kmTotal() {
        double quilometragemTotal = 0;
        for (Rota rota : rotas) {
            quilometragemTotal += rota.getQuilometragem();
        }
        return quilometragemTotal;
    }
    
    public void percorrerRota(Rota rota) {
        if (autonomiaMaxima() >= rota.getQuilometragem()) {
            tanqueAtual -= rota.getQuilometragem() / CONSUMO;
            rotas.add(rota);
            quantRotas++;
        }
    }

   //Gets and Setters
   
    public Object getPlaca() {
        return placa;
    }

    public static int getMaxRotas() {
        return MAX_ROTAS;
    }

    public static double getConsumo() {
        return CONSUMO;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }

    public int getQuantRotas() {
        return quantRotas;
    }

    public void setQuantRotas(int quantRotas) {
        this.quantRotas = quantRotas;
    }

    public double getTanqueAtual() {
        return tanqueAtual;
    }

    public void setTanqueAtual(double tanqueAtual) {
        this.tanqueAtual = tanqueAtual;
    }

    public double getTanqueMax() {
        return tanqueMax;
    }

    public void setTanqueMax(double tanqueMax) {
        this.tanqueMax = tanqueMax;
    }

    public double getTotalReabastecido() {
        return totalReabastecido;
    }

    public void setTotalReabastecido(double totalReabastecido) {
        this.totalReabastecido = totalReabastecido;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }
}
