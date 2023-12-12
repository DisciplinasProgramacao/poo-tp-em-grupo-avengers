import java.util.Date;

public class Manutencao {
    private double quilometragem;
    private double valor;
    private Date data;

    public void fazerManutencao(double quilometragem) {
        this.quilometragem = quilometragem;
        this.valor = 200.0; 
        this.data = new Date();
    }

    public void realizarManutencao() {
        System.out.println("Manutenção realizada em " + data + " - Valor: " + valor);
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "valor=" + valor +
                ", data=" + data +
                '}';
    }
    // Getters e Setters
    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
