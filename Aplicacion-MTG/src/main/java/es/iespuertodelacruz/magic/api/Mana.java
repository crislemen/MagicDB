/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.magic.api;

import java.util.Enumeration;

/**
 *
 * @author risaa
 */
public class Mana {
    
    private String nombre;
    private String tipo;
    private String descripcion;

    /**
     * Constructor de clase con parametros
     * @param nombre del mana
     * @param tipo de mana
     * @param descripcion del mana
     */
    public Mana(String nombre, String tipo, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    /**
     * Constructor vacio
     */
    public Mana(){}

    /**
     * Getter de nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre
     * @param nombre del mana
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
     * @param tipo de mana
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @param descripcion del mana
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
