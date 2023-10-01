

import java.util.ArrayList;
import java.util.List;

public class Frota {
    private int tamanhoFrota;
    private List<Veiculo> veiculos;
    
    public Frota() {
        this.veiculos = new ArrayList<>();
    }
    
    public String relatorioFrota() {
        // Gerar um relatório da frota aqui
        //Total de carros com tamanho do tanque e placa
        return "";
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
            if (veiculo.quantRotas > 0 && veiculo.kmTotal() / veiculo.quantRotas > maiorKmMedia) {
                maiorKmMedia = veiculo.kmTotal() / veiculo.quantRotas;
                veiculoMaiorKmMedia = veiculo;
            }
        }
        return veiculoMaiorKmMedia;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }


    //Get and Set

    public int getTamanhoFrota() {
        return tamanhoFrota;
    }

    public void setTamanhoFrota(int tamanhoFrota) {
        this.tamanhoFrota = tamanhoFrota;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
