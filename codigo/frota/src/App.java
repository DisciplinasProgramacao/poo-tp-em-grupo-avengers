import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Criando instâncias de veículos e adicionando à frota
        Frota frota = new Frota();
        Carro carro1 = new Carro("ABC1234", new Gasolina());
        Van van1 = new Van("DEF5678", new Diesel());
        Caminhao caminhao1 = new Caminhao("GHI9012", new Gasolina());
        
        frota.adicionarVeiculo(carro1);
        frota.adicionarVeiculo(van1);
        frota.adicionarVeiculo(caminhao1);

        // Exibir relatório de rotas de cada veículo
        for (Veiculo veiculo : frota.getVeiculos()) {
            System.out.println(veiculo.relatorioRotas());
        }

        // Exibir quilometragem total percorrida por um veículo
        Veiculo veiculoParaVerificar = frota.localizarVeiculo("ABC1234"); // Exemplo de placa de veículo
        double quilometragemTotal = veiculoParaVerificar.kmTotal();
        System.out.println("Quilometragem total do veículo ABC1234: " + quilometragemTotal);

        // Realizar manutenções de um veículo quando necessárias
        double quilometragemParaManutencao = 10000; // Exemplo de quilometragem para manutenção
        veiculoParaVerificar.realizarManutencao(veiculoParaVerificar, quilometragemParaManutencao);

        // Calcular a despesa total de um veículo (considerando combustível e manutenções)
        double despesaTotalVeiculo = veiculoParaVerificar.calcularDespesaTotal();
        System.out.println("Despesa total do veículo ABC1234: " + despesaTotalVeiculo);

        // Detalhes adicionais
        System.out.println("Quantidade de litros reabastecidos no veículo ABC1234: " + veiculoParaVerificar.getTanque().getTotalReabastecido());
        System.out.println("Quilometragem rodada pelo veículo ABC1234 no mês atual: " + veiculoParaVerificar.KmNoMes());
        System.out.println("Quilometragem total rodada pelo veículo ABC1234: " + veiculoParaVerificar.kmTotal());
    }
}
