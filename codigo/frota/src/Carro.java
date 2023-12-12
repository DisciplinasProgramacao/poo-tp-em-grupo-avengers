import java.util.ArrayList;
import java.util.List;

public class Carro extends Veiculo {

    private static final int MAX_ROTAS = 30;
    private static String veiculo = "Van";
	private double totalReabastecido;
	private int quantRotas;
	private List<Rota> rotas;	
    private String placa;
	private Tanque tanque;
	private Manutencao manutencao = new Manutencao();
    
    public Carro(String placa, String tipoCombustivel) {
        super(placa, veiculo, tipoCombustivel);
        this.placa = placa;
        this.rotas = new ArrayList<>();
        this.quantRotas = 0;
    }
    
    public boolean addRota(Rota rota) {
        if (quantRotas < MAX_ROTAS && autonomiaMaxima() >= Rota.getQuilometragem()) {
            rotas.add(rota);
            quantRotas++;
            return true;
        }
        return false;
    }
    
    public double autonomiaAtual() {
        return tanque.getCapacidadeAtual() * Tanque.getConsumo();
    }
    
    public double autonomiaMaxima() {
        return tanque.getCapacidadeMax() * Tanque.getConsumo();
    }
    
    public double abastecer(double litros) {
        return tanque.abastecer(litros);
    }
    
    public double kmNoMes() {
        double quilometragemMes = 0;
        for (Rota rota : rotas) {
            quilometragemMes += Rota.getQuilometragem();
        }
        return quilometragemMes;
    }
    
    public double kmTotal() {
        double quilometragemTotal = 0;
        for (Rota rota : rotas) {
            quilometragemTotal += Rota.getQuilometragem();
        }
        return quilometragemTotal;
    }
    
    public void percorrerRota(Rota rota) { 
            tanqueAtual -= Rota.getQuilometragem() / Tanque.getConsumo();
            rotas.add(rota);
            quantRotas++;
    }
	
	public void fazerManutencao(){
			manutencao.fazerManutencao(kmTotal());
    }
   //Gets and Setters
   
    public Object getPlaca() {
        return placa;
    }

    public static int getMaxRotas() {
        return MAX_ROTAS;
    }

    public static double getConsumo() {
        return Tanque.getConsumo();
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
}