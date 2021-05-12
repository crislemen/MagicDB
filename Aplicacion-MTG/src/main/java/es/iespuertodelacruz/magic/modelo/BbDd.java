package es.iespuertodelacruz.magic.modelo;

import java.sql.*;
import java.util.ArrayList;

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
     /**
      * Metodo encargado de insertar una carta en la BBDD en la tabla carta
      * @param carta a insertar en la BBDD
      * @throws PersistenciaException
      */
     public void insertar(Carta carta) throws PersistenciaException {
        String sql ="INSERT INTO carta(id,nombre_carta,tipo,simbolo_expansion,rareza,"+
        "coste_mana,coste_mana_convertido,fuerza,resistencia,loyalty,"+
        "descripcion,codigo_artista,color,generated_mana,nombre_formato)"
        +" VALUES ('"+carta.getId()+"', '"+carta.getNombreCarta()+"',"
        +" '"+carta.getTipo()+"', '"+carta.getSimboloExpansion()+"')"
        +" '"+carta.getRareza()+"', '"+carta.getCosteMana()+"',"
        +" '"+carta.getCosteManaConvertido()+"', '"+carta.getFuerza()+"')"
        +" '"+carta.getResistencia()+"', '"+carta.getLoyalty()+"',"
        +" '"+carta.getDescripcion()+"', '"+carta.getCodigoArtista()+"')"
        +" '"+carta.getColor()+"', '"+carta.getGeneratedMana()+"',"
        +" '"+carta.getNombreFormato()+"')";
        actualizar(sql);
     }
     /**
      * Metodo encargado de actualizar la BBDD
      * @param sql a ejecutar
      * @throws PersistenciaException error controlado
      */
   private void actualizar(String sql) throws PersistenciaException {
      Statement statement = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.createStatement();
         statement.executeUpdate(sql);  
      } catch (Exception exception) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
      }finally{
         closeConecction(connection, statement, null);
      }
   }
   /***
    * 
    * @param sql
    * @return
    * @throws PersistenciaException
    */
   private ArrayList<Carta> obtenerListado(String sql) throws PersistenciaException {
      ArrayList<Carta> listaCartas = new ArrayList<>();
      Carta carta = null;
      Statement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;
      try {
         connection = getConnection();
         statement = connection.createStatement();
         resultSet = statement.executeQuery(sql);
         while (resultSet.next()) {
            String id = resultSet.getString("id");
            String nombreCarta = resultSet.getString("nombreCarta");
            String tipo = resultSet.getString("tipo");
            String simboloExpansion = resultSet.getString("simboloExpansion");
            String rareza = resultSet.getString("rareza");
            String costeMana = resultSet.getString("costeMana");
         }
      } catch (Exception e) {
         //TODO: handle exception
      }finally{
         closeConecction(connection, statement, resultSet);
      }
      return listaCartas;
   }
   /**
    * Metodo encartgado de cerrar la conexion a la base de datos
    * @param connection
    * @param statement
    * @param resultSet
    * @throws PersistenciaException
    */
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet) throws PersistenciaException  {
      try {
         if (resultSet != null) {
            resultSet.close();
         }
         if (statement != null) {
            statement.close();
         }
         if (connection != null) {
            connection.close();
         } 
      } catch (Exception exception) {
         throw new PersistenciaException("Se ha producido un error cerrando la coneccion", exception);
      }
      
   }
}
