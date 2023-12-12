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
    
    public double autonomiaAtual() {
        return tanqueAtual * CONSUMO;
    }
    
    public double autonomiaMaxima() {
        return tanqueMax * CONSUMO;
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
    	//Confere antes se o km da rota + o km rodado desde a ultima manutencao nao ultrapassa o valor exigido para manutencoes
    	if(kmManutencao + rota.getQuilometragem() < manutencaoProg) {   
        if (autonomiaMaxima() >= rota.getQuilometragem()) {
            tanqueAtual -= rota.getQuilometragem() / CONSUMO;
            rotas.add(rota);
            quantRotas++;
            //Calcula e soma o valor da despesa de acorda com a KM da rota
            despesa += ( rota.getQuilometragem() / CONSUMO )* valorDiesel;
        }
    	}else {
        //Caso o valor ultrapasse o exigido a manutenção será ordenada
        	manutencao(); 
        }
    }
    
    public void manutencao() {
    	fezManutencao = kmTotal();
    	kmManutencao = 0;
    	//Adicionar 100 reais ao custo da despesa a cada manutencao
    	despesa += 100;
    }
    
    public void consumoTotal() {
    	if (tipoTanque == "diesel") {
    		consumoTotal = (kmTotal() / CONSUMO) * valorDiesel;
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

    public void setTanqueMax() {
        this.tanqueMax = 250;	
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
    
    //Retorna a ultima vez em que o veiculo sofreu uma manutencao
    public double getUltimaManutencao() {
    	return fezManutencao;
    }
    //Retorna a quantidade de KMs até a próxima manutencao obrigatória
    public double getProximaManutencao() {
    	return manutencaoProg - kmManutencao;
    }
    
    //Retorna a despesa total do veículo (manutencoes e kilometragem andada)
    public double getDespesa() {
    	return despesa;
    }
}
