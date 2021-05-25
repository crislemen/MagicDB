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
     * @throws CartaException
     */
    public void validar(Carta carta) throws CartaException{
        String mensaje = "";

        if(carta == null){
            mensaje = "Se esta validando un objeto nulo";
            throw new CartaException(mensaje);
        }
        if(carta.getId() == 0){
            mensaje = "El id es 0 o esta vacio";
        }
        if(carta.getNombreCarta() == null || carta.getNombreCarta().isEmpty()){
            mensaje += "El nombre de la carta el nulo o esta vacio";
        }
        if(carta.getTipo() == null || carta.getTipo().isEmpty()){
            mensaje += "El tipo de la carta el nulo o esta vacio";
        }
        if(carta.getSimboloExpansion() == null || carta.getSimboloExpansion().isEmpty()){
            mensaje += "El simbolo de expansion de la carta el nulo o esta vacio";
        }
        if(carta.getRareza() == '\u0000'){
            mensaje += "La rareza de la carta es nulo o esta vacio";
        }       
        if(carta.getCosteManaConvertido() <= -1){
            mensaje += "El coste de mana convertido de la carta es nulo, esta vacio o es invalido";
        }
        if(carta.getFuerza() == null || carta.getFuerza().isEmpty()){
            mensaje += "La fuerza de la carta es nulo o esta vacio";
        }
        if(carta.getResistencia() == null || carta.getResistencia().isEmpty()){
            mensaje += "La resistencia de la carta es nulo o esta vacio";
        }
        if(carta.getLoyalty() <= -1){
            mensaje += "La lealtad de la carta el nulo, esta vacio o es invalido";
        }
        if(carta.getDescripcion() == null || carta.getDescripcion().isEmpty()){
            mensaje += "La descripcion de la carta es nulo o esta vacio";
        }
        if(carta.getCodigoArtista() <= 0){
            mensaje += "El codigo del artista el nulo, esta vacio o es invalido";
        }
        if(carta.getGeneratedMana() == null || carta.getGeneratedMana().isEmpty()){
            mensaje += "El mana que produce es nulo o esta vacio";
        }
        if(carta.getNombreFormato() == null || carta.getNombreFormato().isEmpty()){
            mensaje += "El nombre del formato es nulo o esta vacio";
        }
        if(!mensaje.isEmpty()){
            throw new CartaException(mensaje);
        }
        

       
    }

    /**
     * Metodo encargado de comprobar si a la hora de insertar el color cumple el
     * patron dado
     * @param color a comprobar
     * @throws CartaException error controlado
     */
    public boolean validarColor(String color) throws CartaException{
        
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
        return resultado;
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
     * @param carta a isnertar
     * @throws PersistenciaException
     * @throws CartaException
     */
    public void insertar(Carta carta) throws PersistenciaException, CartaException {
        validar(carta);
        magicModelo.insertarCarta(carta);
    }

    /**
     * Metodo que elimina una carta
     * @param carta  a eliminar
     * @throws PersistenciaException
     */
    public void eliminar(Carta carta) throws PersistenciaException {
        magicModelo.eliminar(carta);
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
     * @throws PersistenciaException
     */
    public void modificar(Carta carta) throws PersistenciaException {
        magicModelo.modificar(carta);
    }
}
