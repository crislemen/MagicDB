package es.iespuertodelacruz.magic.modelo;

import javax.tools.Diagnostic;

public class MySqlBdDd extends BbDd{
   private static final String DRIVER = "com.mysql.jdbc.Driver";
   private static final String URL = "jbdc:mysql:test.db";
    public MySqlBdDd(String driver, String url, String usuario, String password) {
       super(driver, url, usuario, password);
    }
    public MySqlBdDd( String usuario, String password) {
      super(DRIVER, URL, usuario, password);
   }
 
 }