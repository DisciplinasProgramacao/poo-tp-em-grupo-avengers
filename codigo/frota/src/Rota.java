

public class Rota {
    private double quilometragem;
    private String data;
    private int quantCarro;
    
    public Rota(double quilometragem, String data) {
        this.quilometragem = quilometragem;
        quantCarro++;
        this.data = data;
    }
    
    public String relatorio() {
        // Gerar um relatório da rota aqui
        //Mostar a quantidade de carros e o dia do relatorio
    	StringBuilder relat = new StringBuilder("Relatório de rota");
		relat.append("A rota possui "+ quilometragem +" quilometros ");
    	relat.append(quantCarros + "\n" + data);
        return relat.toString();
    }


    //Get and Set

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
