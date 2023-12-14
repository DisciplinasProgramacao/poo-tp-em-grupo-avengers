import java.util.Date;
class Manutencao {

    private static double quilometragem;
    private static Veiculo veiculo;
    private Rota rota;

    public Manutencao(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public static void fazerManutencao() {
        if (Rota.getQuilometragem() >= quilometragem) {
            quilometragem = Rota.getQuilometragem();

            if (quilometragem % 10000 == 0) {
                System.out.println("Manutenção periódica realizada no veículo " + Veiculo.getPlaca() + " com quilometragem " + quilometragem);
            }
            if (veiculo instanceof Carro) {
                if (quilometragem % 10000 == 0) {
                    System.out.println("Troca de peças realizada no veículo " + Veiculo.getPlaca() + " com quilometragem " + quilometragem);
                }
            } else if (veiculo instanceof Van) {
                if (quilometragem % 12000 == 0) {
                    System.out.println("Troca de peças realizada no veículo " + Veiculo.getPlaca() + " com quilometragem " + quilometragem);
                }
            } else if (veiculo instanceof Furgao) {
                if (quilometragem % 12000 == 0) {
                    System.out.println("Troca de peças realizada no veículo " + Veiculo.getPlaca() + " com quilometragem " + quilometragem);
                }
            } else if (veiculo instanceof Caminhao) {
                if (quilometragem % 20000 == 0) {
                    System.out.println("Manutenção periódica e troca de peças realizada no veículo " + Veiculo.getPlaca() + " com quilometragem " + quilometragem);
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
}