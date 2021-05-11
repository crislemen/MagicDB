package es.iespuertodelacruz.magic.modelo;

import java.sql.*;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class BbDd {
    private String driver;
    private String url;
    private String usuario;
    private String password;

    public BbDd(String driver, String url, String usuario, String password) {
        this.driver = driver;
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }
    private Connection getConnection() throws PersistenciaException {
        Connection connection = null;
  
        try {
           Class.forName(driver);
        if (usuario == null || password == null ) {
           connection = DriverManager.getConnection(url);
        } else {
           DriverManager.getConnection(url, usuario, password);
        }
        } catch (Exception exception) {
           throw new PersistenciaException("No se ha podido establecer la coneccion con la BBDD",exception);
        }
  
        
        return connection;
     }
     public void insertar(Carta carta) throws PersistenciaException {
        String sql ="INSERT INTO carta(id,nombre_carta,tipo,simbolo_expansion,rareza,coste_mana,coste_mana_convertido,fuerza,resistencia,loyalty,descripcion,codigo_artista,color,generated_mana,nombre_formato)"
        +" VALUES ('"+fruta.getIdentificador()+"', '"+fruta.getNombre()+"',"
        +" '"+fruta.getPrecio()+"', '"+carta.getCoste()+"')";
        actualizar(sql);
     }

}
