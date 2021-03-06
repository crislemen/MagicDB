import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.Fichero;

public class FicheroTest {
    String nombre;

    static Fichero fichero = null;
    static String nombreFichero = "ficheroPrueba.txt";
    String mensaFichero = "Esto es una prueba de contenido de fichero";

    @BeforeEach
    public void setUp() throws PersistenciaException {
        if (fichero == null) {
            fichero = new Fichero();
        }
        crearFichero();
    }
    @AfterAll
    public static void after(){
        try {
            fichero.eliminar(nombreFichero);
        } catch (Exception e) {
            fail("Fallo al eliminar el fichero");
        }
    }

    /*
    @AfterEach
    public void after() throws PersistenciaException {
        eliminar();
    }*/

    @Test
    public void leerFicheroTest() {
        String texto = null;
        try {
            texto = fichero.leer(nombreFichero);
            boolean validar = texto.contains(mensaFichero);
            assertTrue(validar, "El programa no lee correctamente el fichero");
        } catch (Exception e) {
            boolean validarMensaje = e.getMessage().contains("Se ha producido un error en la lectura del fichero");
            assertTrue(validarMensaje, "El programa no genera el error correcto");
        }
    }

    @Test
    public void eliminarNoExisteTest() {
        String nombreFichero = "ficheroNoExiste.txt";

        try {
            fichero.eliminar(nombreFichero);
        } catch (PersistenciaException e) {
            boolean validar = e.getMessage().contains("No se puede eliminar un fichero que no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (eliminarNoExisteTest) ha generado un error no controlado");
        }
    }

    @Test
    public void ficheroNoExisteTest() {
        String nombreFichero = "ficheroNoExiste.txt";
        String texto = null;
        try {
            texto = fichero.leer(nombreFichero);
        } catch (PersistenciaException e) {
            boolean validar = e.getMessage().contains("El fichero a leer no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (ficheroNoExisteTest) ha generado un error no controlado");
        }
    }

    
    @Test
    public void throwLeerTest() throws PersistenciaException {

        final Fichero fich = new Fichero();

        Exception exception = assertThrows(Exception.class, () -> {
            fich.leer(nombre);
        });
        assertTrue(exception.getMessage().contains("error"));       
    }

    @Test
    public void throwCrearTest(){
        final Fichero fich = new Fichero();
        String cadenaTexto = null;
        Exception exception = assertThrows(Exception.class, () -> {
            fich.crear(nombre, cadenaTexto);
        });
        assertTrue(exception.getMessage().contains("error"));
    }

    private void crearFichero()  {
        try {
            fichero.crear(nombreFichero, mensaFichero);
        } catch (PersistenciaException e) {
            fail("Se ha producido un error con el fichero");
        }
    }

    private void eliminar()  {

        try {
            fichero.eliminar(nombreFichero);
        } catch (PersistenciaException e) {
            fail("Se ha producido un error con el fichero");
        }

    }

}
