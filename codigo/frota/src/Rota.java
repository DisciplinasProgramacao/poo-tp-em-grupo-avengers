

public class Rota {
    private static double quilometragem;
    private static String data;
    private int quantCarro;
    
    public Rota(double quilometragem, String data) {
        Rota.quilometragem = quilometragem;
        quantCarro++;
        Rota.data = data;
    }
    
    public String relatorio() {
        // Gerar um relatório da rota aqui
        //Mostar a quantidade de carros e o dia do relatorio
    	StringBuilder relat = new StringBuilder("Relatório de rota");
		relat.append("A rota possui "+ quilometragem +" quilometros ");
    	relat.append(quantCarro + "\n" + data);
        return relat.toString();
    }


    //Get and Set

    public static double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        Rota.quilometragem = quilometragem;
    }

    public static String getData() {
        return data;
    }

    public void setData(String data) {
        Rota.data = data;
    }
}
