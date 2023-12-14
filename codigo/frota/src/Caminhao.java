class Caminhao extends Veiculo {

    // Atributos privados
    private static String veiculo = "Caminhao";
    private static final double tamTanque = 250;

    // Métodos construtores
    public Caminhao(String placa, ICombustivel tipoCombustivel) {
        super(placa, veiculo, new Tanque(tamTanque, tipoCombustivel));
    }
}
