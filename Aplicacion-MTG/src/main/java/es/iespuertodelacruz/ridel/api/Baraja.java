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
public class Baraja {
    
    private String nombre;
    private String formato;
    private float precio;
    private int numeroCartas;
    private int balanceMana;
    private String colores;

    /**
     * Construcotr de clase con parametros
     * @param nombre de la baraja
     * @param formato de la baraja
     * @param precio de la baraja
     * @param numeroCartas de la baraja
     * @param balanceMana de la baraja
     * @param colores de la baraja
     */
    public Baraja(String nombre, String formato, float precio, int numeroCartas, int balanceMana, String colores) {
        this.nombre = nombre;
        this.formato = formato;
        this.precio = precio;
        this.numeroCartas = numeroCartas;
        this.balanceMana = balanceMana;
        this.colores = colores;
    }
    
    /**
     * Constructor vacio
     */
    public Baraja(){}

    /**
     * Getter de nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre
     * @param nombre de la baraja
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de formato
     * @return formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Setter de formato
     * @param formato de la baraja
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Getter de precio
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Setter de precio
     * @param precio de la baraja
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Getter de numero de cartas
     * @return numeroCartas
     */
    public int getNumeroCartas() {
        return numeroCartas;
    }

    /**
     * Setter de numero cartas
     * @param numeroCartas de la baraja
     */
    public void setNumeroCartas(int numeroCartas) {
        this.numeroCartas = numeroCartas;
    }

    /**
     * Getter de balance de mana
     * @return balanceMana
     */
    public int getBalanceMana() {
        return balanceMana;
    }

    /**
     * Setter de balance mana
     * @param balanceMana de la baraja
     */
    public void setBalanceMana(int balanceMana) {
        this.balanceMana = balanceMana;
    }

    /**
     * Getter de colores
     * @return colores
     */
    public String getColores() {
        return colores;
    }

    /**
     * Setter de colores
     * @param colores 
     */
    public void setColores(String colores) {
        this.colores = colores;
    }
    
    
    
    
}
