import static org.junit.jupiter.api.Assertions.*;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void insertarArtistasTest() throws IOException{
        try {
            bbDd.insertarArtistas();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
        }
    }
}
