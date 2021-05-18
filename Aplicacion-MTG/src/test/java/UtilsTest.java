import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class UtilsTest {

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

    public static final char CHAR_NULL = '\u0000';

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
     * @throws CartaException
     * @throws PersistenciaException
     */
    public Carta generarCarta(int id, String nombreCarta, String tipo, String simboloExpansion, char rareza, String costeMana, int costeManaConvertido, String fuerza,
                                String resistencia, int loyalty,  String descripcion, int codigoArtista, String color, String generatedMana, String nombreFormato) throws CartaException, PersistenciaException{
        
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
