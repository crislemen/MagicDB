import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.Fichero;

public class FicheriTest {
    String nombre;
    Fichero fichero;

    @BeforeEach
    public void setUp() {
        if (fichero == null) {
            fichero = new Fichero();
        }
    }

    @Test
    public void crearFichero(){

        nombre = "m.txt";
        try {
            fichero.crear(nombre, "prueba");
        } catch (PersistenciaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void leerFichero() {
        /*
         * try { nombre = "../../../src/main/resources/sql/InsertsArtista.sql";
         * fichero.leerResource(nombre); } catch (Exception e) {
         * 
         * fail("Se ha producido un error no controlado:"+e.getMessage()); }
         */
    }

}
