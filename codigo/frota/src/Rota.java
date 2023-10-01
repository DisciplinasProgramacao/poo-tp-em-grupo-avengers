

public class Rota {
    private double quilometragem;
    private String data;
    
    public Rota(double quilometragem, String data) {
        this.quilometragem = quilometragem;
        this.data = data;
    }
    
    public String relatorio() {
        // Gerar um relatório da rota aqui
        //Mostar a quantidade de carros e o dia do relatorio
        return "";
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
