import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Statement;
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

public class BbDdTest {

    BbDdTest bbDd;
    Connection connection;
    Statement statement; 
    ResultSet resultSet;

    @BeforeEach
    public void setUp(){
        if(bbDd == null){
            bbDd = new BbDdTest();
        }
        
    }

    /*
    @Test
    public void he() throws SQLException{
        new BbDdTest();
        Connection connection = DriverManager.getConnection("jbdc:mysql:test.db", null, null);
        assertEquals(connection != null, true);
    }*/

    @Test
    public void h(){
        assertTrue(true);
    }

}
