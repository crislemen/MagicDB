
import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CartaTest extends UtilsTest{
    
    Carta carta;
    Carta carta2;
    
    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";
    
    @BeforeEach
    public void setUp() throws CartaException, PersistenciaException {
        if(carta == null){
            carta = new Carta();
        }
        carta = generarCarta(11111, "Bibliopex assistant", "artifact", "ORI", 'C', "{3}{G}", 4, "3", "3", 3, "descripcion", 7, "W", "{R}", "Pauper");
        
        carta2 = generarCarta(0, null, null, null, CHAR_NULL, null, 0, null, null, 0, null, 0, null, null, null);
    }

    
    @Test
    public void comprobarCarta() {
        assertNotNull(carta2, "El objeto no se ha generado correctamente");
        assertEquals(11111, carta.getId(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getNombreCarta().contains("Bibliopex assistant"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getTipo().contains("artifact"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getSimboloExpansion().contains("ORI"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals('C', carta.getRareza(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getCosteMana().contains("{3}{G}"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(4, carta.getCosteManaConvertido(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getFuerza().contains("3"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getResistencia().contains("3"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(3, carta.getLoyalty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getDescripcion().contains("descripcion"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(7, carta.getCodigoArtista(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getColor().contains("W"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getGeneratedMana().contains("{R}"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getNombreFormato().contains("Pauper"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
    }
    
    
    
}
