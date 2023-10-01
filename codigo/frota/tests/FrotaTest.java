
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class FrotaTest {
    private Frota frota;

    @Before
    public void setUp() {
        frota = new Frota();
    }

    @Test
    public void testAdicionarVeiculo() {
        Veiculo veiculo = new Veiculo("XYZ789", 70, 70);
        frota.adicionarVeiculo(veiculo);
        assertEquals(1, frota.getVeiculos().size()); // Verifica se o veículo foi adicionado à frota
    }
    
}

