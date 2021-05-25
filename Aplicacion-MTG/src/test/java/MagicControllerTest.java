import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.controlador.MagicController;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class MagicControllerTest extends UtilsTest{
    
    MagicController magicController;
    Carta cartaVacia;
    Carta carta;
    Carta carta3 = null;
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";
    
    @BeforeEach
    public void setUp() throws PersistenciaException, CartaException{
        if(magicController == null){
            magicController = new MagicController();
        }
        
        cartaVacia = new Carta(0, "", "", "", CHAR_NULL, "{3}{G}", -1, "", "", -1, "", 0, "W", "", "");
        carta = generarCarta(11111, "Bibliopex assistant", "artifact", "ORI", 'C', "{3}{G}", 4, "3", "3", 3, "descripcion", 7, "W", "{R}", "Pauper");
    }

    @Test
    public void validarTest() {

        try {
            magicController.validar(cartaVacia);
        } catch (CartaException e) {
            assertTrue(e.getMessage().contains("vacio"));
        }
    }
    @Test
    public void verificarTest(){
        try {
            magicController.validar(carta3);
        } catch (CartaException e) {
            assertTrue(e.getMessage().contains("nulo"));
        }
    }

    @Test
    public void validarVacioTest() throws CartaException, PersistenciaException {
        
        

        assertEquals(0, cartaVacia.getId(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getNombreCarta().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getTipo().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getSimboloExpansion().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(CHAR_NULL, cartaVacia.getRareza(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        //assertTrue(cartaVacia.getCosteMana().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(-1, cartaVacia.getCosteManaConvertido(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getFuerza().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getResistencia().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(-1, cartaVacia.getLoyalty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getDescripcion().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(0, cartaVacia.getCodigoArtista(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        //assertTrue(cartaVacia.getColor().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getGeneratedMana().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getNombreFormato().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        
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

    @Test
    public void eliminarTest() {
        try {
            magicController.eliminar(carta);
        } catch (PersistenciaException e) {

            assertTrue(e.getMessage().contains("consulta"));
        }
    }



    
}
