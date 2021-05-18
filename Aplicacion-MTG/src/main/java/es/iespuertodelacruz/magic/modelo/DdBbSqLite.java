package es.iespuertodelacruz.magic.modelo;

import javax.tools.Diagnostic;

import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class DdBbSqLite extends BbDd {
   
   private static final String DRIVER = "org.sqlite.JDBC";
   private static final String URL  = "jdbc:sqlite:test.db";
   
   public DdBbSqLite(String driver, String url, String usuario, String password) throws PersistenciaException {
      super(driver, url, usuario, password);
   }

   public DdBbSqLite(String usuario, String password) throws PersistenciaException {
      super(DRIVER, URL, usuario, password);
   }

  


}