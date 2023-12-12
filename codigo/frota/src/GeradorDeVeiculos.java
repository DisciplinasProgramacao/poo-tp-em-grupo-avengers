import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GeradorDeVeiculos {

    // Método para gerar uma string aleatória com 4 letras e 3 números intercalados
    public static String gerarPlaca() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 4; i++) {
            sb.append(letras.charAt(random.nextInt(letras.length())));
        }

        for (int i = 0; i < 3; i++) {
            sb.insert(random.nextInt(sb.length() + 1), random.nextInt(10));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] tiposVeiculos = {"Carro", "Caminhao", "Van", "Furgao"};
        String[] tiposCombustivel = {"Alcool", "Gasolina", "Diesel"};
        Random random = new Random();
        List<Veiculo> listaVeiculos = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String placa = gerarPlaca();
            String tipoVeiculo = tiposVeiculos[random.nextInt(tiposVeiculos.length)];
            String tipoCombustivel = tiposCombustivel[random.nextInt(tiposCombustivel.length)];
            Veiculo veiculo = new Veiculo(placa, tipoVeiculo, tipoCombustivel);
            listaVeiculos.add(veiculo);
        }

        // Exemplo de como acessar os veículos na lista
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println("Placa: " + veiculo.getPlaca() + ", Tipo: " + veiculo.getTipoVeiculo() + ", Combustível: " + veiculo.getTipoCombustivel());
        }
    }
}

