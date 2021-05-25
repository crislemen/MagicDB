import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.controlador.MagicController;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.BbDd;

public class BbDdTest {

    BbDd bbDd;
    Connection connection;
    Statement statement; 
    ResultSet resultSet;

    @BeforeEach
    public void setUp() throws PersistenciaException, SQLException{
        if(bbDd == null){
            bbDd = new BbDd("org.sqlite.JDBC", "jdbc:sqlite:test.db", null, null);
            
        }
        bbDd.getConnection();
        
    }

    
    @Test
    public void getconnectionUrltest() throws SQLException, PersistenciaException{
        assertEquals(connection != null, true);
    }
    @Test
    public void InsertarArtistasTest() throws IOException, SQLException {
        try {
            bbDd.insertarArtistas();
        } catch (PersistenciaException e) {
            assertTrue(e.getMessage().contains("insertar"));
        }
    }
}
