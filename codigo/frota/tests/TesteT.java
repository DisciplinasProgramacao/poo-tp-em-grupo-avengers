public class TesteT {

    public static void main(String[] args) {
        Tanque tanque = new Tanque(70, 30);

        // Exibe o estado inicial do tanque
        exibirEstadoTanque(tanque);

        double litrosAbastecidos = tanque.abastecer(50);
        System.out.println("Litros abastecidos: " + litrosAbastecidos);

        // Exibe o estado do tanque após o abastecimento
        exibirEstadoTanque(tanque);

        // Calcula autonomia máxima do veículo com o combustível atual
        double autonomiaMaxima = tanque.autonomiaMaxima();
        System.out.println("Autonomia máxima: " + autonomiaMaxima + " km");

        // Calcula autonomia atual do veículo com o combustível atual
        double autonomiaAtual = tanque.autonomiaAtual();
        System.out.println("Autonomia atual: " + autonomiaAtual + " km");

        // Exibe o total de litros reabastecidos desde a criação do tanque
        System.out.println("Total de litros reabastecidos: " + tanque.getTotalReabastecido());
    }

    /**
     * Exibe o estado atual do tanque.
     *
     * @param tanque O tanque a ser exibido.
     */
    private static void exibirEstadoTanque(Tanque tanque) {
        System.out.println("Capacidade Máxima: " + tanque.getCapacidadeMaxima() + " litros");
        System.out.println("Capacidade Atual: " + tanque.getCapacidadeAtual() + " litros");
    }
}
