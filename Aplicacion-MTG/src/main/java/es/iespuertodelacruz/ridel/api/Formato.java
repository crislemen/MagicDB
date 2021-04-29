/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.ridel.api;

/**
 *
 * @author risaa
 */
public class Formato {
    
    private String nombre;
    private String descripcion;
    private String bans;

    /**
     * Constructor de clase
     * @param nombre del formato
     * @param descripcion del formato
     * @param bans del formato
     */
    public Formato(String nombre, String descripcion, String bans) {
        this.nombre = nombre;
        this.descripcion = descripcion;

        this.bans = bans;
    }
    
    /**
     * Constructor vacio
     */
    public Formato(){}

    /**
     * Getter de bans
     * @return bans
     */
    public String getBans() {
        return bans;
    }

    /**
     * Setter de bans
     * @param bans del formato
     */
    public void setBans(String bans) {
        this.bans = bans;
    }
    
    /**
     * Getter de nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre
     * @param nombre del formato
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de descripcion
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de descripcion
     * @param descripcion del formato
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
