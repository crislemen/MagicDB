
import es.iespuertodelacruz.magic.api.Carta;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class CartaTest {
    
    Carta carta;
    Carta carta2;
    

    private int idDefault = 384444;
    private String nombreCartaDefault = "Archmage Emiritus";
    private String tipoDefault = "Human Wizard";
    private String simboloExpansionDefault = "ORI";
    private char rarezaDefault = 'R';
    private String costeManaDefault = "{1}{R}";
    private int costeManaConvertidoDefault = 2;
    private String fuerzaDefault = "2";
    private String resistenciaDefault = "2";
    private int loyaltyDefault = 2;
    private String descripcionDefault = "Magecraft- Whenever you cast or copy an instant"
            + " or sorcery spell, draw a card";
    private int codigoArtistaDefault = 6;
    private String colorDefault = "W";
    private String generatedManaDefault = "{G}";
    private String nombreFormatoDefault = "Commander";
    
    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";
    private static final char CHAR_NULL = '\u0000';
    @BeforeEach
    public void setUp() {
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
    
    
    /**
     * Metodo encargado de generar una carta
     * @param id de la carta
     * @param nombreCarta de la carta
     * @param tipo de la carta
     * @param simboloExpansion de la carta
     * @param rareza de la carta
     * @param costeMana de la carta
     * @param costeManaConvertido de la carta
     * @param fuerza de la carta
     * @param resistencia de la carta
     * @param loyalty de la carta
     * @param descripcion de la carta
     * @param codigoArtista de la carta
     * @param color de la carta
     * @param generatedMana de la carta
     * @param nombreFormato de la carta
     * @return carta
     */
    private Carta generarCarta(int id, String nombreCarta, String tipo, String simboloExpansion, char rareza, String costeMana, int costeManaConvertido, String fuerza,
                                String resistencia, int loyalty,  String descripcion, int codigoArtista, String color, String generatedMana, String nombreFormato){
        
        Carta carta = null;
        
        if(id != 0 && nombreCarta != null && tipo != null && simboloExpansion != null && rareza != CHAR_NULL && costeMana != null && costeManaConvertido !=0 && fuerza != null 
        && resistencia != null && loyalty !=0 && descripcion != null && codigoArtista != 0 && color != null && generatedMana != null && nombreFormato != null){
            
            carta = new Carta(id, nombreCarta, tipo, simboloExpansion, rareza, costeMana, costeManaConvertido, fuerza, resistencia, loyalty, descripcion, codigoArtista, color, generatedMana, nombreFormato);
            
        } else {
            carta = new Carta();
            
            carta.setId(idDefault);
            carta.setNombreCarta(nombreCartaDefault);
            carta.setTipo(tipoDefault);
            carta.setSimboloExpansion(simboloExpansionDefault);
            carta.setRareza(rarezaDefault);
            carta.setCosteMana(costeManaDefault);
            carta.setCosteManaConvertido(costeManaConvertidoDefault);
            carta.setFuerza(fuerzaDefault);
            carta.setResistencia(resistenciaDefault);
            carta.setLoyalty(loyaltyDefault);
            carta.setDescripcion(descripcionDefault);
            carta.setCodigoArtista(codigoArtistaDefault);
            carta.setColor(colorDefault);
            carta.setGeneratedMana(generatedManaDefault);
            carta.setNombreCarta(nombreCartaDefault);
            carta.setNombreFormato(nombreFormatoDefault);
        }
        
        return carta;
        
    }
}
