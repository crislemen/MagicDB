package es.iespuertodelacruz.magic.modelo;

import java.util.ArrayList;

import es.iespuertodelacruz.magic.api.*;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class MagicModelo {

    DdBbSqLite persistencia;

    public MagicModelo() throws PersistenciaException {
        persistencia = new DdBbSqLite(null, null);
    }

    /**
     * Metodo encargado de insertar una carta
     * 
     * @param carta objeto a insertar
     * @throws PersistenciaException error controlado
     */
    public void insertarCarta(Carta carta) throws PersistenciaException {
        persistencia.insertar(carta);
    }

    /**
     * Metodo encargado de eliminar
     * 
     * @param carta a eliminar
     * @throws PersistenciaException error controlado
     */
    public void eliminar(Carta carta) throws PersistenciaException {
        persistencia.eliminar(carta);
    }

    /**
     * Metodo encargado de actualizar
     * 
     * @param carta a modificar
     * @throws PersistenciaException error controlado
     */
    public void modificar(Carta carta) throws PersistenciaException {
        persistencia.modificar(carta);
    }

    /**
     * Metodo encargado de buscar uan carta por id
     * 
     * @param carta objeto a buscar
     * @throws PersistenciaException error controlado
     */
    public Carta buscarPorID(int id) throws PersistenciaException {
        return (Carta) persistencia.obtenerCartaId(id);
    }

    /**
     * Metodo encargado de bsucar una carta por nombre
     * 
     * @param carta objeto a buscar
     * @throws PersistenciaException error controlado
     */
    public Carta buscarPorNombre(String nombreCarta) throws PersistenciaException {
        return (Carta) persistencia.obtenerCartaNombre(nombreCarta);
    }

    /**
     * Metodo encargado de buscar una carta por color
     * 
     * @param carta objeto a buscar
     * @throws PersistenciaException error controlado
     */
    public Carta buscarPorCosteDeMana(String costeMana) throws PersistenciaException {
        return (Carta) persistencia.obtenerCartaMana(costeMana);
    }

    /**
     * Metodo encargado de devolver listar todos los valores
     * @return obtenerListado()
     * @throws PersistenciaException error controlado
     */
    public ArrayList<Carta> obtenerListado() throws PersistenciaException{
        return persistencia.obtenerListado();
    }

}
