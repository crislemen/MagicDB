
import es.iespuertodelacruz.magic.api.Carta;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class CartaTest {
    
    Carta carta;
    Carta carta2;
    
    private String nombreDefault = "Archmage Emiritus";
    private String tipoDefault = "Human Wizard";
    private String descripcionDefault = "Magecraft- Whenever you cast or copy an instant"
            + " or sorcery spell, draw a card";
    private String simboloExpansionDefault = "A";
    private int costeManaDefault = 4;
    private int fuerzaDefault = 2;
    private int resistenciaDefault = 2;
    private float precioDefault = 1.00f;
    private String atributoDefault = null;
    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";
    
    @BeforeEach
    public void setUp() {
        if(carta == null){
            carta = new Carta();
        }
        carta = generarCarta("Bibliopex assistant", "artifact", "descripcion", "B", 5, 5, 5, 20, "flying");
        
        carta2 = generarCarta(null, null, null, null, 0, 0, 0, 0, null);
    }

    
    @Test
    public void comprobarCarta() {
        assertNotNull(carta2, "El objeto no se ha generado correctamente");
        assertTrue(carta.getNombre().contains("Bibliopex assistant"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getTipo().contains("artifact"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getDescripcion().contains("descripcion"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getSimboloExpansion().contains("B"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(carta.getCosteMana(), 5, LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(carta.getFuerza(), 5, LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(carta.getResistencia(), 5, LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(carta.getPrecio(), 20 , LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(carta.getAtributo().contains("flying"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
    }
    
    
    /**
     * 
     * @param nombre de la carta
     * @param tipo de la carta
     * @param descripcion de la carta
     * @param simboloExpansion de la carta
     * @param costeMana de la carta
     * @param fuerza de la carta
     * @param resistencia de la carta
     * @param precio de la carta
     * @param atributo de la carta
     * @return carta
     */
    private Carta generarCarta(String nombre, String tipo, String descripcion, 
            String simboloExpansion, int costeMana, int fuerza, int resistencia, 
            float precio, String atributo){
        
        Carta carta = null;
        
        if(nombre !=null && tipo !=null && descripcion !=null && simboloExpansion !=null && costeMana != 0 && fuerza != 0
                && resistencia != 0 && precio != 0 && atributo != null){
            
            carta = new Carta(nombre, tipo, descripcion, simboloExpansion, 
                    costeMana, fuerza, resistencia, precio, atributo);
            
        } else {
            carta = new Carta();
            
            carta.setNombre(nombreDefault);
            carta.setTipo(tipoDefault);
            carta.setDescripcion(descripcionDefault);
            carta.setSimboloExpansion(simboloExpansionDefault);
            carta.setCosteMana(costeManaDefault);
            carta.setFuerza(fuerzaDefault);
            carta.setResistencia(resistenciaDefault);
            carta.setPrecio(precioDefault);
            carta.setAtributo(atributoDefault);
        }
        
        return carta;
        
    }
}
