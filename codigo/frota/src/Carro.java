class Carro extends Veiculo {

    // Atributos privados
    private double totalReabastecido;
    private double tanqueAtual;
    private String placa;

    // Métodos construtores
    public Carro(double consumo, String placa) {
        super();
        this.placa = placa;
        this.tanqueAtual = tanqueAtual;
        this.totalReabastecido = totalReabastecido;
    }

    // Métodos get
    public double getTotalReabastecido() {
        return totalReabastecido;
    }

    // Outros métodos
    public double kmNoMes() {
        double quilometragemMes = 0;
        for (Rota rota : rotas) {
            quilometragemMes += rota.getQuilometragem();
        }
        return quilometragemMes;
    }

    public double kmTotal() {
        double quilometragemTotal = 0;
        for (Rota rota : rotas) {
            quilometragemTotal += rota.getQuilometragem();
        }
        return quilometragemTotal;
    }

    public void percorrerRota(Rota rota) {
        double consumo = Tanque.getConsumo();
        double quantidadeCombustivel = rota.getQuilometragem() / consumo;
        tanqueAtual -= quantidadeCombustivel;
        rotas.add(rota);
        quantRotas++;
    }
    public Manutencao fazerManutencao(double quilometragem) {
        Manutencao manutencao = new Manutencao(quilometragem);
        Manutencao.fazerManutencao();
        return manutencao;
    }
}