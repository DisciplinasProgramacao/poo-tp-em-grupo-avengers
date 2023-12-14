
class Manutencao {

    private static double quilometragem;
    private static Veiculo veiculo;

    public Manutencao(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public static void fazerManutencao(Veiculo veiculo, double quilometragem) {
        if (veiculo.kmTotal() >= quilometragem) {
            if (veiculo instanceof Carro) {
                int intervalo = 10000;
                if (quilometragem % intervalo == 0) {
                    System.out.println("Manutenção realizada no veículo " + veiculo.getPlaca() + " com quilometragem " + quilometragem);
                }
            } else if (veiculo instanceof Van || veiculo instanceof Furgao) {
                int intervalo = 12000;
                if (quilometragem % intervalo == 0) {
                    System.out.println("Manutenção realizada no veículo " + veiculo.getPlaca() + " com quilometragem " + quilometragem);
                }
            } else if (veiculo instanceof Caminhao) {
                int intervalo = 20000;
                if (quilometragem % intervalo == 0) {
                    System.out.println("Manutenção realizada no veículo " + veiculo.getPlaca() + " com quilometragem " + quilometragem);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Manutenção{" +
                "quilometragem=" + quilometragem +
                ", veiculo=" + veiculo.getPlaca() +
                '}';
    }

    public static double getValorManutenao() {
        return 0;
    }
}