import ESI.Pessoa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPessoa {

    @Test
    void constructor() {
        Pessoa pessoa = new Pessoa("Maria José", "23386779000");
        assertEquals("Maria José", pessoa.getNome());
        assertEquals("23386779000", pessoa.getCpf());
    }

    @Test
    void setNomeValido() {
        Pessoa pessoa = new Pessoa("João da Silva", "23386779000");
        assertDoesNotThrow(() -> pessoa.setNome("Carlos Eduardo"));
        assertEquals("Carlos Eduardo", pessoa.getNome());
    }

    @Test
    void setNomeInvalido() {
        Pessoa pessoa = new Pessoa("João da Silva", "23386779000");
        assertThrows(IllegalArgumentException.class, () -> pessoa.setNome("João"));
        assertThrows(IllegalArgumentException.class, () -> pessoa.setNome(""));
    }

    @Test
    void setCpfValido() {
        Pessoa pessoa = new Pessoa("Joana da Silva", "23386779000");
        assertDoesNotThrow(() -> pessoa.setCpf("233.867.790-00"));
        assertEquals("23386779000", pessoa.getCpf());
    }

    @Test
    void setCpfInvalido() {
        Pessoa pessoa = new Pessoa("Joana da Silva", "23386779000");
        assertThrows(IllegalArgumentException.class, () -> pessoa.setCpf("11111111111")); // dígitos iguais
        assertThrows(IllegalArgumentException.class, () -> pessoa.setCpf("123456"));       // muito curto
    }

    @Test
    void nomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Pessoa("", "23386779000"));
    }

    @Test
    void nomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Pessoa(null, "23386779000"));
    }

    @Test
    void cpfNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Pessoa("Maria José", null));
    }
}
