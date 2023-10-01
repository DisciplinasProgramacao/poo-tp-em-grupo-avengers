import static org.junit.Assert.*;
import org.junit.Test;

public class TanqueTest {
    @Test
    public void testAbastecer() {
        Tanque tanque = new Tanque(50.0, 40.0);
        double litrosAbastecidos = tanque.abastecer(30.0);
        assertEquals(10.0, litrosAbastecidos, 0.01); // Verifica se abasteceu corretamente
        assertEquals(50.0, tanque.getCapacidadeAtual(), 0.01); // Verifica a capacidade atual igual à máxima
    }
}
