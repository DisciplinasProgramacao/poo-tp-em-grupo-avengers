

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Frota frota = new Frota();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("========== Menu ==========");
            System.out.println("1. Adicionar Veículo");
            System.out.println("2. Adicionar Rota a Veículo");
            System.out.println("3. Abastecer Veículo");
            System.out.println("4. Relatório de Frota");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite a capacidade do tanque: ");
                    double capacidadeTanque = scanner.nextDouble();
                    System.out.print("Digite a capacidade atual do tanque: ");
                    double  capacidadeAtual = scanner.nextDouble();

                    Veiculo veiculo = new Veiculo(placa, capacidadeTanque, capacidadeAtual);
                    frota.adicionarVeiculo(veiculo);
                    System.out.println("Veículo adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a placa do veículo: ");
                    placa = scanner.nextLine();
                    Veiculo veiculoEncontrado = frota.localizarVeiculo(placa);
                    
                    if (veiculoEncontrado != null) {
                        System.out.print("Digite a quilometragem da rota: ");
                        double quilometragem = scanner.nextDouble();
                        System.out.print("Digite a data da rota: ");
                        String data = scanner.next();
                        
                        Rota rota = new Rota(quilometragem, data);
                        veiculoEncontrado.addRota(rota);
                        System.out.println("Rota adicionada com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a placa do veículo: ");
                    placa = scanner.nextLine();
                    veiculoEncontrado = frota.localizarVeiculo(placa);
                    
                    if (veiculoEncontrado != null) {
                        System.out.print("Digite a quantidade de litros a serem abastecidos: ");
                        double litrosAbastecidos = scanner.nextDouble();
                        veiculoEncontrado.abastecer(litrosAbastecidos);
                        System.out.println("Abastecimento realizado com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("========== Relatório de Frota ==========");
                    System.out.println(frota.relatorioFrota());
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
