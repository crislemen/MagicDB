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
public class Artista {
    
    private int codigo;
    private String nombre;
    private String apellido;
    private int numeroArtes;

    /**
     * Constructor con parametros
     * @param codigo del artista 
     * @param nombre del artista
     * @param apellido del artista
     * @param numeroArtes del artista
     */
    public Artista(int codigo, String nombre, String apellido, int numeroArtes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroArtes = numeroArtes;
    }
    
    /**
     * Constructor vacio
     */
    public Artista(){}

    /**
     * Getter de codigo
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Setter de codigo
     * @param codigo dela rtista
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
     * @param nombre dela artista
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de apellido1
     * @return apellido1
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter de apellido1
     * @param apellido1 del artista
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Getter de numero de artes
     * @return numeroArtes
     */
    public int getNumeroArtes() {
        return numeroArtes;
    }

    /**
     * Setter de numero de artes
     * @param numeroArtes del artista
     */
    public void setNumeroArtes(int numeroArtes) {
        this.numeroArtes = numeroArtes;
    }

    
    
    
}
