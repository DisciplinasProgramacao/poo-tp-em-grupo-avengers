import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DadosAleatorios {

    public static void main(String[] args) {
        String[] tiposCombustivel = { "Gasolina", "Álcool", "Diesel" };
        String[] placas = { "ABC1234", "DEF5678", "GHI9012", "JKL3456", "MNO7890" };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_veiculos.txt"))) {
            Random rand = new Random();

            for (int i = 0; i < 10; i++) { // Gera dados para 10 veículos
                String tipoCombustivel = tiposCombustivel[rand.nextInt(tiposCombustivel.length)];
                String placa = placas[rand.nextInt(placas.length)];
                double tanque = rand.nextDouble() * 100; // Capacidade do tanque aleatória até 100 litros
                double preco = rand.nextDouble() * 10; // Preço do combustível aleatório até R$ 10 por litro

                // Escreve os dados no arquivo
                writer.write("Placa: " + placa + ", Tipo: " + tipoCombustivel + ", Tanque: " + tanque + "L, Preço: R$" + preco + " por litro\n");
            }
            System.out.println("Dados escritos no arquivo 'dados_veiculos.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
