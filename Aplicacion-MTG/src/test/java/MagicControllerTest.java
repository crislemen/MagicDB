import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.controlador.MagicController;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class MagicControllerTest extends UtilsTest{
    
    MagicController magicController;
    Carta carta;
    Carta carta1;

    @BeforeEach
    public void setUp() throws PersistenciaException{
        if(magicController == null){
            magicController = new MagicController();
        }
        try {
            carta = generarCarta(11111, "Bibliopex assistant", "artifact", "ORI", 'C', "{3}{G}", 4, "3", "3", 3, "descripcion", 7, "W", "{R}", "Pauper");
        } catch (CartaException e) {
            fail("Se ha producido un error a la hora de inicializar el test");
        }     
    }

    
    @Test
    public void verificarManaTest() {
        
        String coste_Mana = "{2}{W";
        try {
            magicController.validarMana(coste_Mana);
            
        } catch (CartaException e) {
            
            assertTrue(e.getMessage().contains("no tiene"));
        }
        
        
        
    }
    @Test 
    public void verificarColorTest(){
        String color = "{M}";

        try {
            magicController.validarColor(color);
        } catch (CartaException e) {
            assertTrue(e.getMessage().contains("no tiene"));
        }

    }
    
    @Test
    public void buscarCartaPorId(){

        try {
            magicController.buscarPorID(carta);
        } catch (PersistenciaException e) {
            e.getMessage().contains("s");
        }
    }

    @Test
    public void buscarPorNombreTest(){

        try {
            magicController.buscarPorNombre(carta);
        } catch (PersistenciaException e) {
           
            e.printStackTrace();
        }
    }

    @Test
    public void buscarPorCosteManaTest(){

        try {
            magicController.buscarPorCosteMana(carta);
        } catch (PersistenciaException e) {
            
            e.printStackTrace();
        }
    }



    
}
