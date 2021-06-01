import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.vista.App;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

public class AppTest {
    String[] args = null;
    private ByteArrayInputStream testIn;
    App app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new App();
        }
    }
    @Test
    public void buscarNombreTest() {
        String[] args = null;
        testIn = new ByteArrayInputStream("1 3 1 nombre 0".getBytes());
        System.setIn(testIn);
        try {
            App.main(args);
        } catch (Exception e) {
            fail("Se ha producido un error realizando la busqueda");
        }
    }

    @Test
    public void buscarIDTest() {
        String[] args = null;
        testIn = new ByteArrayInputStream("1 3 2 123 0".getBytes());
        System.setIn(testIn);
        try {
            App.main(args);
        } catch (Exception e) {
            fail("Se ha producido un error realizando la busqueda");
        }
    }

    @Test
    public void buscarCosteManaTest() {
        String[] args = null;
        testIn = new ByteArrayInputStream("1 3 3 {3}{W} 0".getBytes());
        System.setIn(testIn);
        try {
            App.main(args);
        } catch (Exception e) {
            fail("Se ha producido un error realizando la busqueda");
        }
    }

    @Test
    public void salirTest() {
        String[] args = null;
        testIn = new ByteArrayInputStream("0".getBytes());
        System.setIn(testIn);
        try {
            App.main(args);
        } catch (Exception e) {
            fail("Se ha producido un error realizando la busqueda");
        }
    }
    @Test
    public void usuarioBuscarNombreTest() {
        String[] args = null;
        testIn = new ByteArrayInputStream("2 3 1 nombre 0".getBytes());
        System.setIn(testIn);
        try {
            App.main(args);
        } catch (Exception e) {
            fail("Se ha producido un error realizando la busqueda");
        }
    }

    @Test
    public void usuarioBuscarIDTest() {
        String[] args = null;
        testIn = new ByteArrayInputStream("2 3 2 123 0".getBytes());
        System.setIn(testIn);
        try {
            App.main(args);
        } catch (Exception e) {
            fail("Se ha producido un error realizando la busqueda");
        }
    }

    @Test
    public void usuarioBuscarCosteManaTest() {
        String[] args = null;
        testIn = new ByteArrayInputStream("2 3 3 {3}{W} 0".getBytes());
        System.setIn(testIn);
        try {
            App.main(args);
        } catch (Exception e) {
            fail("Se ha producido un error realizando la busqueda");
        }
    }
}
