class Carro extends Veiculo {

    // Atributos privados
    private static String veiculo = "Carro";
    private static final double tamTanque = 50;

    // Métodos construtores
    public Carro(String placa, ICombustivel tipoCombustivel) {
        super(placa, veiculo, new Tanque(tamTanque, tipoCombustivel));
    }
}