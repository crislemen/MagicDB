package es.iespuertodelacruz.magic.exception;

public class PersistenciaException extends Exception{
    /**
     * Excepcion con mensaje
     * @param mensaje del error
     */
    public PersistenciaException(String mensaje) {
    super(mensaje);
    }
    /**
     * Excepcion con mensaje y causa
     * @param mensaje del error
     * @param causa del error
     */
    public PersistenciaException(String mensaje,Exception causa) {
        super(mensaje,causa);
    }
            

}
