import java.util.ArrayList;
import java.util.List;

public class Caminhao {
    private static final int MAX_ROTAS = 30;
    
	private double totalReabastecido;
	private int quantRotas;
	private Rota[] rotas	
    private String placa;
	private Tanque tanque;
	private manutencao Manutencao = new Manutencao();
    
    public Caminhao(double consumo, String placa) {
		tanque = new Tanque(250,4,"diesel");
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
    
    public double autonomiaAtual() {
        return tanque.getCapacidadeAtual() * tanque.getConsumo();
    }
    
    public double autonomiaMaxima() {
        return tanque.getCapacidadeMax * tanque.getConsumo();
    }
    
    public double abastecer(double litros) {
        return tanque.abastecer(litros);
    }
    
    public double kmNoMes() {
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
            tanqueAtual -= rota.getQuilometragem() / tanque.getConsumo();
            rotas.add(rota);
            quantRotas++;
        }
    }
	
	public void fazerManutencao(){
			manutencao.fazerManutencao(kmTotal())
    }
   //Gets and Setters
   
    public Object getPlaca() {
        return placa;
    }

    public static int getMaxRotas() {
        return MAX_ROTAS;
    }

    public static double getConsumo() {
        return tanque.getConsumo();
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

    public double getTotalReabastecido() {
        return tanque.geTotalReabastecido();
    }
    
    public void getConsumo() {
    	return tanque.getConsumo();
    }

    
}
