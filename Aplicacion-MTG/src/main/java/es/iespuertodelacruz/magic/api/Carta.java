package es.iespuertodelacruz.magic.api;

public class Carta {
    
    private int id;
    private String nombreCarta;
    private String tipo;
    private String simboloExpansion;
    private char rareza;
    private String costeMana;
    private int costeManaConvertido;
    private String fuerza;
    private String resistencia;
    private int loyalty;
    private String descripcion;
    private int codigoArtista;
    private String color;
    private String generatedMana;
    private String nombreFormato;

    /**
     * Constructor de clase
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
     */
    public Carta(int id, String nombreCarta, String tipo, String simboloExpansion, char rareza, String costeMana,
            int costeManaConvertido, String fuerza, String resistencia, int loyalty, String descripcion, int codigoArtista,
            String color, String generatedMana, String nombreFormato) {
        this.id = id;
        this.nombreCarta = nombreCarta;
        this.tipo = tipo;
        this.simboloExpansion = simboloExpansion;
        this.rareza = rareza;
        this.costeMana = costeMana;
        this.costeManaConvertido = costeManaConvertido;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.loyalty = loyalty;
        this.descripcion = descripcion;
        this.codigoArtista = codigoArtista;
        this.color = color;
        this.generatedMana = generatedMana;
        this.nombreFormato = nombreFormato;
    }

    /**
     * Constructor por defecto
     */
    public Carta(){}
    
    /**
     * Getter de id carta
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de id de carta
     * @param id de la carta
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de nombre carta
     * @return nombreCarta
     */
    public String getNombreCarta() {
        return nombreCarta;
    }

    /**
     * Setter de nombre carta
     * @param nombreCarta de la carta
     */
    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
    }

    /**
     * Getter de tipo 
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter de tipo
     * @param tipo de la carta
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter de simbolo expansion
     * @return simboloExpansion
     */
    public String getSimboloExpansion() {
        return simboloExpansion;
    }

    /**
     * Setter de simbolo de expansion
     * @param simboloExpansion de la carta
     */
    public void setSimboloExpansion(String simboloExpansion) {
        this.simboloExpansion = simboloExpansion;
    }

    /**
     * Getter de rareza
     * @return rareza
     */
    public char getRareza() {
        return rareza;
    }

    /**
     * Setter de rareza
     * @param rareza de la carta
     */
    public void setRareza(char rareza) {
        this.rareza = rareza;
    }

    /**
     * Getter de coste mana
     * @return costeMana
     */
    public String getCosteMana() {
        return costeMana;
    }

    /**
     * Setter de coste mana
     * @param costeMana de la carta
     */
    public void setCosteMana(String costeMana) {
        this.costeMana = costeMana;
    }

    /**
     * Getter de coste mana convertido
     * @return consteManaConvertido
     */
    public int getCosteManaConvertido() {
        return costeManaConvertido;
    }

    /**
     * Setter de coste mana convertido
     * @param costeManaConvertido de la carta
     */
    public void setCosteManaConvertido(int costeManaConvertido) {
        this.costeManaConvertido = costeManaConvertido;
    }

    /**
     * Getter de fuerza
     * @return fuerza
     */
    public String getFuerza() {
        return fuerza;
    }

    /**
     * Setter de fuerza
     * @param fuerza de la carta
     */
    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Getter de resistencia
     * @return resistencia
     */
    public String getResistencia() {
        return resistencia;
    }

    /**
     * Setter de resistencia
     * @param resistencia de la carta
     */
    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Getter de loyalty
     * @return loyalty
     */
    public int getLoyalty() {
        return loyalty;
    }

    /**
     * Setter de loyalty
     * @param loyalty de la carta
     */
    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    /**
     * Getter de descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de descripcion
     * @param descripcion de la carta
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de codigo artista
     * @return codigoArtista
     */
    public int getCodigoArtista() {
        return codigoArtista;
    }

    /**
     * Setter de codigo artista
     * @param codigoArtista de la carta
     */
    public void setCodigoArtista(int codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    /**
     * Getter de color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter de color
     * @param color de la carta
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter de generated mana
     * @return generatedMana
     */
    public String getGeneratedMana() {
        return generatedMana;
    }

    /**
     * Setter de generated mana
     * @param generatedMana de la carta
     */
    public void setGeneratedMana(String generatedMana) {
        this.generatedMana = generatedMana;
    }

    /**
     * Getter de nombre formato
     * @return nombreFormato
     */
    public String getNombreFormato() {
        return nombreFormato;
    }

    /**
     * Setter de nombre formato
     * @param nombreFormato de la carta
     */
    public void setNombreFormato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }
       
    
}