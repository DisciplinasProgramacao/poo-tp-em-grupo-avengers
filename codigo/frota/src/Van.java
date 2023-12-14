public class Van extends Veiculo{

    private static String veiculo = "Van";
    private static final double tamTanque = 60;

    public Van(String placa, ICombustivel tipoCombustivel) {
        super(placa, veiculo, new Tanque(tamTanque, tipoCombustivel));
        
    }
    
}
