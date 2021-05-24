package es.iespuertodelacruz.magic.controlador;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.MagicModelo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagicController {
    MagicModelo magicModelo;

    public MagicController() throws PersistenciaException {
        magicModelo = new MagicModelo();
    }

    /**
     * Metodo encargado de la validacion del objeto
     * @param carta a vlaidar
     */
    public void validar(Carta carta){

        

    }

    /**
     * Metodo encargado de comprobar si a la hora de insertar el color cumple el
     * patron dado
     * @param color a comprobar
     * @throws CartaException error controlado
     */
    public void validarColor(String color) throws CartaException{

        String patronColor = "^[W,R,G,B,U]{1}$";

        boolean resultado = false;
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile(patronColor);
        matcher = pattern.matcher(color);
        resultado = matcher.find();

        if (!resultado) {
            throw new CartaException("El coste de mana:" +color+ ", no tiene un formato correcto");
        }
    }

    
    /**
     * Metodo encargado de comprobar si a la hora de insertar el coste de mana cumple
     * el patron dado
     * @param costeMana a comprobar
     * @throws CartaException error controlado
     */
    public boolean validarMana(String costeMana) throws CartaException{

        String patronMana = "^[{]{1}([0-9,X])[}]{1}([{]{1}[W,R,G,B,U]{1}[}]{1}){0,25}$";
       
        boolean resultado = false;
        Pattern pattern;
        Matcher matcher;


        pattern = Pattern.compile(patronMana);
        matcher = pattern.matcher(costeMana);
        resultado = matcher.matches();

        if (!resultado) {
            throw new CartaException("El coste de mana: " +costeMana+ " , no tiene un formato correcto");
        }

        return resultado;
       
    }

    /**
     * Metodo que inserta una carta
     * @throws PersistenciaException
     */
    public void insertar(Carta carta) throws PersistenciaException {
        magicModelo.insertarCarta(carta);
    }

    /**
     * Metodo que elimina una carta
     */
    public void eliminar() {

    }

    /**
     * Metodo encargado de buscar por el id
     * @param carta a buscar
     * @throws PersistenciaException error controlado
     */
    public void buscarPorID(Carta carta) throws PersistenciaException {
        magicModelo.buscarPorID(carta);
    }

    /**
     * Metodo encargado de buscar por el nombre
     * @param carta a buscar
     * @throws PersistenciaException error controlado
     */
    public void buscarPorNombre(Carta carta) throws PersistenciaException{
        magicModelo.buscarPorNombre(carta);
    }

    /**
     * Metodo encargado de buscar por el coste de mana
     * @param carta a buscar
     * @throws PersistenciaException error controlado
     */
    public void buscarPorCosteMana(Carta carta) throws PersistenciaException{
        magicModelo.buscarPorCosteDeMana(carta);
    }
    /**
     * Metodo que modifica una carta
     */
    public void modificar() {

    }
}
