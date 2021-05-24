package es.iespuertodelacruz.magic.exception;

public class FicheroException extends Exception{

    public FicheroException(String message) {
        super(message);
    }

    public FicheroException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
