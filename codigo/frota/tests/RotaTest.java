import static org.junit.Assert.*;
import org.junit.Test;


public class RotaTest {
    @Test
    public void testGetQuilometragem() {
        Rota rota = new Rota(100.0, "2023-10-01");
        double quilometragem = rota.getQuilometragem();
        assertEquals(100.0, quilometragem, 0.01); // Verifica se a quilometragem é a esperada
    }

}

