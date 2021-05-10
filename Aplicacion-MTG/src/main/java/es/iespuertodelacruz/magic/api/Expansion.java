/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.magic.api;

/**
 *
 * @author risaa
 */
public class Expansion {
    
    private String nombre;
    private String simbolo;
    private String fechaLanzamiento;
    private String descripcion;

    /**
     * Constructor de clase con parametros
     * @param nombre de la expansion
     * @param simbolo de la expansion
     * @param fechaLanzamiento de la expansion
     */
    public Expansion(String nombre, String simbolo, String fechaLanzamiento, String descripcion) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
    }
    
    /**
     * Constructor vacio
     */
    public Expansion(){}

    /**
     * Getter de nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre
     * @param nombre de la expansion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de simbolo
     * @return simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Setter de simbolo
     * @param simbolo de la expansion
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Getter de fecha lanzamiento
     * @return fechaLanzamiento
     */
    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    /**
     * Setter de fecha lanzamiento
     * @param fechaLanzamiento de la expansion
     */
    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
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
     * @param descripcion de la expansion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
