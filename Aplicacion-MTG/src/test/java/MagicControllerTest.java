import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.controlador.MagicController;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class MagicControllerTest{
    
    MagicController magicController;
    Carta carta;
    Carta carta1;

    @BeforeEach
    public void setUp() throws PersistenciaException{
        if(magicController == null){
            magicController = new MagicController();
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
    public void h(){
        assertTrue(true);
    }
    /*
    @Test
    public void buscarPorColorTest(){}

    @Test
    public void buscarPorCosteDeManaTest(){}

    @Test
    public void buscarPorNombreTest(){}

    @Test
    public void buscarPorIDTest(){
        
        
    }*/

    
}
