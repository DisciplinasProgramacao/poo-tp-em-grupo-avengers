class Caminhao extends Veiculo {

    // Atributos privados
    private static final String VEICULO = "Caminhao";
    private static final double TAM_TANQUE = 250;

    // Métodos construtores
    public Caminhao(String placa, ICombustivel tipoCombustivel) {
        super(placa, VEICULO, new Tanque(TAM_TANQUE, tipoCombustivel));
    }
}
