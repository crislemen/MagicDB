import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.exception.FicheroException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.Fichero;

public class FicheriTest {
    String nombre;

    Fichero fichero = null;
    String nombreFichero = "ficheroPrueba.txt";
    String mensaFichero = "Esto es una prueba de contenido de fichero";

    @BeforeEach
    public void setUp() throws PersistenciaException {
        if (fichero == null) {
            fichero = new Fichero();
        }
        crearFichero();
    }
    @AfterEach
    public void after() throws PersistenciaException{
        eliminar();
    }

    @Test
    public void leerFicheroTest() {
        String texto = null;
        try {
            texto = fichero.leer(nombreFichero);
            boolean validar = texto.contains(mensaFichero);
            assertTrue(validar, "El programa no lee correctamente el fichero");
        } catch (Exception e) {
            fail("Se ha producido un error en el test leer fichero");
        }
    }

    private void crearFichero() throws PersistenciaException {
        fichero.crear(nombreFichero, mensaFichero);
    }

    private void eliminar() throws PersistenciaException {
        
        fichero.eliminar(nombreFichero);
              
    }

}
