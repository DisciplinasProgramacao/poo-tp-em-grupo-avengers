import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VeiculoTest {
    private Veiculo veiculo;

    @Before
    public void setUp() {
        veiculo = new Veiculo("ABC123", 100, 80);
    }

    @Test
    public void testAbastecer() {
        double litrosAbastecidos = veiculo.abastecer(20.0);
        assertEquals(20, litrosAbastecidos, 0.0); // Verifica se abasteceu corretamente
        assertEquals(20, veiculo.getTanqueAtual(), 0.0); // Verifica o tanque atual
    }

    @Test
    public void testAddRota() {
        Rota rota = new Rota(100.0, "2023-10-01");
        boolean rotaAdicionada = veiculo.addRota(rota);
        assertTrue(rotaAdicionada); // Verifica se a rota foi adicionada com sucesso
        assertEquals(1, veiculo.getQuantRotas()); // Verifica a quantidade de rotas
    }
    
}
