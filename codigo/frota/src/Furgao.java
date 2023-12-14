import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Furgao extends Veiculo{

    private static final double tamTanque = 80;
    private static String veiculo = "Furgao";

    public Furgao(String placa, ICombustivel tipoCombustivel) {
        super(placa, veiculo, new Tanque(tamTanque, tipoCombustivel));
    }
}
