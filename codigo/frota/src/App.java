import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final String FILENAME = "dados_veiculos.txt";
    private Frota frota;

    public App() {
        frota = new Frota();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("======== Menu ========");
            System.out.println("1. Adicionar Veículo");
            System.out.println("2. Realizar Manutenção");
            System.out.println("3. Exibir Relatórios");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarVeiculo();
                    break;
                case 2:
                    realizarManutencao();
                    break;
                case 3:
                    exibirRelatorios();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    private void adicionarVeiculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adicionar Veículo:");
        
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        
        System.out.print("Digite o tipo de veículo (Carro, Van, Furgao, Caminhao): ");
        String tipoVeiculo = scanner.nextLine();
        
        System.out.print("Digite o tipo de combustível (álcool, gasolina, diesel): ");
        String tipoCombustivel = scanner.nextLine();

        scanner.close();
        
        // Aqui você precisa criar o objeto do tipo de combustível com base na entrada do usuário
        ICombustivel combustivel = criarCombustivel(tipoCombustivel);
        
        // Crie um novo veículo com as informações fornecidas pelo usuário e adicione à frota
        if (tipoVeiculo.equalsIgnoreCase("Carro")) {
            Carro carro = new Carro(placa, combustivel);
            frota.adicionarVeiculo(carro);
        } else if (tipoVeiculo.equalsIgnoreCase("Van")) {
            Van van = new Van(placa, combustivel);
            frota.adicionarVeiculo(van);
        } else if (tipoVeiculo.equalsIgnoreCase("Furgao")) {
            Furgao furgao = new Furgao(placa, combustivel);
            frota.adicionarVeiculo(furgao);
        } else if (tipoVeiculo.equalsIgnoreCase("Caminhao")) {
            Caminhao caminhao = new Caminhao(placa, combustivel);
            frota.adicionarVeiculo(caminhao);
        } else {
            System.out.println("Tipo de veículo inválido.");
        }
    }
    

    private ICombustivel criarCombustivel(String tipoCombustivel) {
        ICombustivel combustivel;
    
        if (tipoCombustivel.equalsIgnoreCase("alcool")) {
            combustivel = new Alcool();
        } else if (tipoCombustivel.equalsIgnoreCase("gasolina")) {
            combustivel = new Gasolina();
        } else if (tipoCombustivel.equalsIgnoreCase("diesel")) {
            combustivel = new Diesel();
        } else {
            throw new IllegalArgumentException("Tipo de combustível inválido.");
        }
    
        return combustivel;
    }
    

    private void realizarManutencao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Realizar Manutenção:");
    
        System.out.print("Digite a placa do veículo para realizar a manutenção: ");
        String placa = scanner.nextLine();
    
        scanner.close();

        Veiculo veiculo = frota.localizarVeiculo(placa);
        if (veiculo != null) {
            System.out.print("Digite a quilometragem atual do veículo: ");
            double quilometragemAtual = scanner.nextDouble();
    
            Manutencao.fazerManutencao(veiculo, quilometragemAtual);
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }
    

    private void exibirRelatorios() {
        System.out.println("Relatório da Frota:");
        System.out.println(frota.relatorioFrota());
    
        // Adicione mais lógica para exibir outros relatórios, como relatório de rotas, etc.
    }
    

    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            // Lógica para salvar os dados dos veículos no arquivo
            // Percorra a lista de veículos da frota e grave suas informações no arquivo
            for (Veiculo veiculo : frota.getVeiculos()) {
                writer.write("Placa: " + veiculo.getPlaca() + ", Tipo: " + veiculo.getTipoVeiculo() + ", ...");
                writer.newLine();
            }
            System.out.println("Dados dos veículos foram salvos no arquivo " + FILENAME);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados dos veículos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.exibirMenu();
        app.salvarDados();
    }
}
