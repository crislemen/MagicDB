import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.BbDd;
import es.iespuertodelacruz.magic.modelo.Fichero;

public class BbDdTest {

    static BbDd bbDd;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    static Fichero fichero;
    static String nombreFichero = "magic.db";

    @BeforeEach
    public void setUp() throws PersistenciaException, SQLException {
        if (bbDd == null) {
            bbDd = new BbDd("org.sqlite.JDBC", "jdbc:sqlite:magic.db", null, null);

        }
        bbDd.getConnection();

    }

    @AfterAll
    public static void after() {
        try {
            bbDd.closeConecction(null, null, null);
        } catch (PersistenciaException e) {
            fail("Fallo al cerrar la conexion con la base de datos");
        }
        /*
         * try { fichero.eliminar(nombreFichero); } catch (PersistenciaException e) {
         * fail("Fallo a la hora de eliminar el archivo"); }
         */
    }

    @Test
    public void insertarArtistasTest() throws IOException {

        try {
            bbDd.insertarArtistas();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));

        }
    }

    @Test
    public void insertarBarajasTest() throws IOException {
        try {
            bbDd.insertarBarajas();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));

        }
    }

    @Test
    public void insertarFormatosTest() throws IOException {
        try {
            bbDd.insertarFormatos();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));

        }
    }

    @Test
    public void insertarBarajaCartasTest() throws IOException {
        try {
            bbDd.insertarBarajaCarta();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
        }

    }

    @Test
    public void insertarBarajaColoresTest() throws IOException {
        try {
            bbDd.insertarBarajaColores();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
        }
    }

    @Test
    public void insertarBarajaFormatoTest() throws IOException {
        try {
            bbDd.insertarBarajaFormato();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
        }
    }

    @Test
    public void insertarBarajaManaTest() throws IOException {
        try {
            bbDd.insertarBarajaMana();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
        }

    }

    @Test
    public void insertarCartaTest() throws IOException {
        try {
            bbDd.insertarCarta();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));

        }

    }

    @Test
    public void insertarExpansionTest() throws IOException {
        try {
            bbDd.insertarExpansion();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));

        }
    }

    @Test
    public void insertarManaProduceTest() throws IOException {
        try {
            bbDd.insertarManaProduce();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));

        }
    }

    @Test
    public void insertarManaTest() throws IOException {
        try {
            bbDd.insertarMana();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));

        }
    }

    @Test
    public void tt() throws PersistenciaException {
        final BbDd generalEx = new BbDd("org.sqlite.JDBC", "jdbc:sqlite:magic.db", null, null);
        String sql = null;
        Exception exception = assertThrows(Exception.class, () -> {
            generalEx.obtenerListado(sql);
        });
        assertTrue(exception.getMessage().contains("error"));
    }

    @Test
    public void throwGetConnectionTest() throws PersistenciaException {
        BbDd bbDd = new BbDd("org.sqlite.JDBC", "jdbc:sqlite:magic.db", "root", "toor");

        try {
            bbDd.getConnection();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("establecer"));
        }

    }

    @Test
    public void throwBuscarTest() throws PersistenciaException {
        final BbDd generalEx = new BbDd("org.sqlite.JDBC", "jdbc:sqlite:magic.db", null, null);

        String sql = null;

        Exception exception = assertThrows(Exception.class, () -> {
            generalEx.buscar(sql);
        });
        assertTrue(exception.getMessage().contains("error"));
    }

    /*
    @Test
    public void throwInsertArtistaTest() throws PersistenciaException, IOException {
        final BbDd generalEx = new BbDd("org.sqlite.JDBC", "jdbc:sqlite:magic.db", null, null);

        Exception exception = assertThrows(Exception.class, () -> {

            Fichero fichero = new Fichero();
            String sql = fichero.leerResource("sql/InsertsArtisa.sql");
            generalEx.insertarArtistas();
            bbDd.actualizar(sql);
            

        });
        assertTrue(exception.getMessage().contains("error"));
    }
    */

    /*
     * @Test public void t() throws PersistenciaException {
     * 
     * final BbDd generalEx = new BbDd("org.sqlite.JDBC", "jdbc:sqlite:magic.db",
     * null, null);
     * 
     * Exception exception = assertThrows(Exception.class, () -> {
     * 
     * generalEx.closeConecction(null, null, null);
     * 
     * }); assertTrue(exception.getMessage().contains("error"));
     * 
     * }
     */

}
