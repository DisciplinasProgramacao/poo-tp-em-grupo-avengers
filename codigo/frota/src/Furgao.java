public class Furgao extends Veiculo{

    private static final double TAM_TANQUE = 80;
    private static final String VEICULO = "Furgao";

    public Furgao(String placa, ICombustivel tipoCombustivel) {
        super(placa, VEICULO, new Tanque(TAM_TANQUE, tipoCombustivel));
    }
}
