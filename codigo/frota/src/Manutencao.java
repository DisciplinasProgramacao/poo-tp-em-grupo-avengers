import java.util.Date;
public class Manutencao {

    private double valor;
    private Date data;
    private String descricao;

    public Manutencao(double valor, Date data, String descricao) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    //Métodos Getters e Setters 
    public double getValor() {
        return valor;
    }
    public Date getData() {
        return data;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Mostra dados da manutenção realizada. 
     */
    public void realizarManutencao() {
        System.out.println("Manutenção realizada em " + data + " - Descrição: " + descricao + " - Valor: " + valor);
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "valor=" + valor +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
