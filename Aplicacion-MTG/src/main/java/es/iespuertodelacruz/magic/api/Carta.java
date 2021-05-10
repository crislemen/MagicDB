package es.iespuertodelacruz.magic.api;

public class Carta {
    
    private String nombre;
    private String tipo;
    private String descripcion;
    private String simboloExpansion;
    private int costeMana;
    private int fuerza;
    private int resistencia;
    private float precio;
    private String atributo;
       
    /**
     * Constructor de clase con parametros
     * @param nombre de la carta
     * @param tipo de la carta
     * @param descripcion de la carta
     * @param simboloExpansion simbolo de la expansion de la carta
     * @param costeMana coste de mana convertido de la carta
     * @param fuerza de la carta
     * @param resistencia de la carta
     * @param precio de la carta
     */
    public Carta(String nombre, String tipo, String descripcion, String simboloExpansion, 
            int costeMana, int fuerza, int resistencia, float precio, String atributo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.simboloExpansion = simboloExpansion;
        this.costeMana = costeMana;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.precio = precio;
        this.atributo = atributo;
    }

    /**
     * Construcor vacío
     */
    public Carta(){}
    
    /**
     * Getter de nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre
     * @param nombre de la carta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @param tipo de carta
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter descripción
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
     * Getter de simbolo expansion
     * @return simboloExpansion
     */
    public String getSimboloExpansion() {
        return simboloExpansion;
    }

    /**
     * Setter simbolo expansio
     * @param simboloExpansion de la carta
     */
    public void setSimboloExpansion(String simboloExpansion) {
        this.simboloExpansion = simboloExpansion;
    }

    /**
     * Getter de coste mana
     * @return costeMana
     */
    public int getCosteMana() {
        return costeMana;
    }

    /**
     * Setter de coste mana
     * @param costeMana de la carta
     */
    public void setCosteMana(int costeMana) {
        this.costeMana = costeMana;
    }

    /**
     * Getter fuerza
     * @return fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Setter fuerza
     * @param fuerza de la carta 
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /**
     * Getter resistencia
     * @return resistencia
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * Setter reistencia
     * @param resistencia de la carta 
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Getter precio
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Setter precio
     * @param precio de la carta 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Getter atributo
     * @return atributo
     */
    public String getAtributo() {
        return atributo;
    }

    /**
     * Setter atributo
     * @param atributo de la carta 
     */
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
      
}
