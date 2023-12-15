class Carro extends Veiculo {

    // Atributos privados
    private static final String VEICULO = "Carro";
    private static final double TAM_TANQUE = 50;

    // Métodos construtores
    public Carro(String placa, ICombustivel tipoCombustivel) {
        super(placa, VEICULO, new Tanque(TAM_TANQUE, tipoCombustivel));
    }
}