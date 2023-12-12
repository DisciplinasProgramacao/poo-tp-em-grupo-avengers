import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    
    //#region utilidades
    static Scanner teclado;
     /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

     /**
     * Pausa para leitura de mensagens em console
     * 
     * @param teclado Scanner de leitura
     */
    static void pausa() {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    /**
     * Encapsula uma leitura de teclado, com mensagem personalizada. A mensagem sempre é completada com ":". Retorna uma string 
     * que pode ser posteriormente convertida.
     * @param mensagem A mensagem a ser exibida, sem pontuação final.
     * @return String lida do usuário.
     */
    public static String leitura(String mensagem){
        System.out.print(mensagem+": ");
        return teclado.nextLine();
    }

    /**
     * Método para montagem de menu. Lê as opções de um arquivo e as numera automaticamente a partir de 1.
     * @param nomeArquivo Nome do arquivo texto com as opções (uma por linha)
     * @return Opção do usuário (int)
     * @throws FileNotFoundException em caso de arquivo não encontrado.
     */
    public static int menu(String nomeArquivo) throws FileNotFoundException {
        limparTela();
        File arqMenu = new File(nomeArquivo);
        Scanner leitor = new Scanner(arqMenu, "UTF-8");
        System.out.println(leitor.nextLine());
        System.out.println("==========================");
        int contador = 1;
        while(leitor.hasNextLine()){
            System.out.println(contador + " - " + leitor.nextLine());
            contador++;
        }
        System.out.println("0 - Sair");
        System.out.print("\nSua opção: ");
        int opcao = Integer.parseInt(teclado.nextLine());
        leitor.close();
        return opcao;
    }
    //#endregion 
        public static Frota menuFrota() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Frota frota = new Frota();
        String nomeArq = "C:\\Users\\ramon\\Documents\\GitHub\\poo-tp-em-grupo-avengers\\codigo\\frota\\src\\MenuFrota.txt";
        int opcao = -1;

        while(opcao != 0) {
            limparTela();
            opcao = menu(nomeArq);
            switch(opcao) {
                case 1 -> {
                    // Exibir relatórios de rotas de cada veículo
                    System.out.println("========== Relatórios de Rotas de Cada Veículo ==========");
                    for (Veiculo veiculo : frota.getVeiculos()) {
                        System.out.println("Placa: " + veiculo.getPlaca());
                        System.out.println(veiculo.relatorioRotas());
                        System.out.println("===============================");
                    }
                }
                case 2 -> {
                    // Calcular quilometragem total percorrida por um veículo
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculoEncontrado = frota.localizarVeiculo(placa);

                    if (veiculoEncontrado != null) {
                        System.out.println("Quilometragem total percorrida pelo veículo: " + veiculoEncontrado.kmTotal());
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                }
                case 3 -> {
                    // Realizar manutenções de um veículo
                    System.out.print("Digite a placa do veículo para realizar manutenção: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculoEncontrado = frota.localizarVeiculo(placa);

                    if (veiculoEncontrado != null) {
                        veiculoEncontrado.realizarManutencao();
                        System.out.println("Manutenção realizada com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                }
                case 4 -> {
                    // Mostrar despesa total de um veículo
                    System.out.print("Digite a placa do veículo para mostrar despesa total: ");
                    String placa = scanner.nextLine();
                    Veiculo veiculoEncontrado = frota.localizarVeiculo(placa);

                    if (veiculoEncontrado != null) {
                        System.out.println("Despesa total do veículo: " + veiculoEncontrado.calcularDespesaTotal());
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                }
                case 0 -> {
                    System.out.println("Retornando ao menu anterior...");
                }
            }
            pausa();
        }
        return frota;
    }

    public static void main(String[] args) throws Exception {
        teclado = new Scanner(System.in);
        String nomeArq = "C:\\Users\\ramon\\Documents\\GitHub\\poo-tp-em-grupo-avengers\\codigo\\frota\\src\\MenuFrota.txt";
        int opcao = -1;

        while(opcao != 0) {
            limparTela();
            opcao = menu(nomeArq);
            switch(opcao) {
                case 1:
                    menuFrota();
                    break;
            }
        }
        System.out.println("FROTA agradece!");
        teclado.close();
    }
}
