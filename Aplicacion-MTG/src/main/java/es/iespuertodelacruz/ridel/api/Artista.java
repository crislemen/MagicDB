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
public class Artista {
    
    private int codigo;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int numeroArtes;

    /**
     * Constructor con parametros
     * @param codigo del artista 
     * @param nombre del artista
     * @param apellido1 del artista
     * @param apellido2 del artista
     * @param numeroArtes del artista
     */
    public Artista(int codigo, String nombre, String apellido1, String apellido2, int numeroArtes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
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
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Setter de apellido1
     * @param apellido1 del artista
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Getter de apellido2
     * @return apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Setter de apellido2
     * @param apellido2 dela artista
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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
