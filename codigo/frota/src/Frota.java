import java.util.ArrayList;
import java.util.List;

public class Frota {
    private List<Veiculo> veiculos;

    public Frota() {
        this.veiculos = new ArrayList<>();
    }

    public String relatorioFrota() {
        StringBuilder relatorio = new StringBuilder("Relatório da Frota:\n");
        for (Veiculo veiculo : veiculos) {
            relatorio.append("Placa: ").append(veiculo.getPlaca()).append(", Tipo: ").append(veiculo.getTipoVeiculo())
                    .append(", Tanque: ").append(veiculo.getTanque().getCapacidadeMax()).append("L\n");
        }
        return relatorio.toString();
    }

    public Veiculo localizarVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public double kmTotal() {
        double quilometragemTotal = 0;
        for (Veiculo veiculo : veiculos) {
            quilometragemTotal += veiculo.kmTotal();
        }
        return quilometragemTotal;
    }

    public Veiculo maiorKmTotal() {
        Veiculo veiculoMaiorKmTotal = null;
        double maiorKmTotal = 0;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.kmTotal() > maiorKmTotal) {
                maiorKmTotal = veiculo.kmTotal();
                veiculoMaiorKmTotal = veiculo;
            }
        }
        return veiculoMaiorKmTotal;
    }

    public Veiculo maiorKmMedia() {
        Veiculo veiculoMaiorKmMedia = null;
        double maiorKmMedia = 0;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getQuantRotas() > 0 && veiculo.kmTotal() / veiculo.getQuantRotas() > maiorKmMedia) {
                maiorKmMedia = veiculo.kmTotal() / veiculo.getQuantRotas();
                veiculoMaiorKmMedia = veiculo;
            }
        }
        return veiculoMaiorKmMedia;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    // Getters e Setters

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
