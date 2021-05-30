import static org.junit.jupiter.api.Assertions.*;

import java.beans.Statement;
import java.io.IOException;
import java.net.URISyntaxException;
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
    public void insertarArtistasTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarArtistas();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }

        try {
            bbDd.insertarArtistas();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }


    @Test
    public void insertarBarajasTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarBarajas();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }
        try {
            bbDd.insertarBarajas();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    @Test
    public void insertarFormatosTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarFormatos();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }
        try {
            bbDd.insertarFormatos();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    @Test
    public void insertarBarajaCartasTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarBarajaCarta();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }

        try {
            bbDd.insertarBarajaCarta();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }


    @Test
    public void insertarBarajaColoresTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarBarajaColores();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));           
        }

        try {
            bbDd.insertarBarajaColores();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    @Test
    public void insertarBarajaFormatoTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarBarajaFormato();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));           
        }
        try {
            bbDd.insertarBarajaFormato();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    @Test
    public void insertarBarajaManaTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarBarajaMana();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }

        try {
            bbDd.insertarBarajaMana();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    @Test
    public void insertarCartaTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarCarta();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }/*
        try {
            bbDd.insertarCarta();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }*/
    }



    @Test
    public void insertarExpansionTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarExpansion();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }
        try {
            bbDd.insertarExpansion();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    @Test
    public void insertarManaProduceTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarManaProduce();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }
        try {
            bbDd.insertarManaProduce();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    @Test
    public void insertarManaTest() throws IOException, URISyntaxException{
        try {
            bbDd.insertarMana();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
            
        }
        try {
            bbDd.insertarMana();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    
}
