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

    public Carta(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCarta() {
        return nombreCarta;
    }

    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSimboloExpansion() {
        return simboloExpansion;
    }

    public void setSimboloExpansion(String simboloExpansion) {
        this.simboloExpansion = simboloExpansion;
    }

    public char getRareza() {
        return rareza;
    }

    public void setRareza(char rareza) {
        this.rareza = rareza;
    }

    public String getCosteMana() {
        return costeMana;
    }

    public void setCosteMana(String costeMana) {
        this.costeMana = costeMana;
    }

    public int getCosteManaConvertido() {
        return costeManaConvertido;
    }

    public void setCosteManaConvertido(int costeManaConvertido) {
        this.costeManaConvertido = costeManaConvertido;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public String getResistencia() {
        return resistencia;
    }

    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(int codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGeneratedMana() {
        return generatedMana;
    }

    public void setGeneratedMana(String generatedMana) {
        this.generatedMana = generatedMana;
    }

    public String getNombreFormato() {
        return nombreFormato;
    }

    public void setNombreFormato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }
       
    
}