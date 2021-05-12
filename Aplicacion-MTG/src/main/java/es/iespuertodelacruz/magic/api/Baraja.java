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
public class Baraja {
    
    private int codigo;
    private String nombre;
    private float precio;
    private int numeroCartas;
    private int balanceMana;

    /**
     * Construcotr de clase con parametros
     * @param codigo de la baraja
     * @param nombre de la baraja
     * @param precio de la baraja
     * @param numeroCartas de la baraja
     * @param balanceMana de la baraja
     */
    public Baraja(int codigo, String nombre, float precio, int numeroCartas, int balanceMana) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.numeroCartas = numeroCartas;
        this.balanceMana = balanceMana;
    }
    
    /**
     * Constructor vacio
     */
    public Baraja(){}

    
    /**
     * Getter de codigo
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Setter de codigo
     * @param codigo de la baraja
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
     * @param nombre de la baraja
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
}
