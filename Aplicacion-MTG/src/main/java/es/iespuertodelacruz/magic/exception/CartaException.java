package es.iespuertodelacruz.magic.exception;

public class CartaException extends Exception{

    /**
     * Constructor con mensaje
     * @param message de la excepcion
     */
    public CartaException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaj ey causa
     * @param message de la excepcion
     * @param cause de la excepcion
     */
    public CartaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
