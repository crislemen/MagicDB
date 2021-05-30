package es.iespuertodelacruz.magic.modelo;

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
    public void buscarPorID(Carta carta) throws PersistenciaException {
        persistencia.obtenerCartaId(carta.getId());
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
    public void buscarPorCosteDeMana(Carta carta) throws PersistenciaException {
        persistencia.obtenerCartaMana(carta.getCosteMana());
    }

}
