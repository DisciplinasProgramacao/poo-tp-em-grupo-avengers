public class Van extends Veiculo{

    private static final String VEICULO = "Van";
    private static final double TAM_TANQUE = 60;

    public Van(String placa, ICombustivel tipoCombustivel) {
        super(placa, VEICULO, new Tanque(TAM_TANQUE, tipoCombustivel));
        
    }
    
}
