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

   /**
    * Metodo que se encarga de realizar la conexion con la base de datos
    * 
    * @return conecction
    * @throws PersistenciaException error controlado
    */
   private Connection getConnection() throws PersistenciaException {
      Connection connection = null;

      try {
         Class.forName(driver);
         if (usuario == null || password == null) {
            connection = DriverManager.getConnection(url);
         } else {
            DriverManager.getConnection(url, usuario, password);
         }
      } catch (Exception exception) {
         throw new PersistenciaException("No se ha podido establecer la coneccion con la BBDD", exception);
      }

      return connection;
   }

   /**
    * Metodo encargado de insertar una carta en la BBDD en la tabla carta
    * 
    * @param carta a insertar en la BBDD
    * @throws PersistenciaException
    */
   public void insertar(Carta carta) throws PersistenciaException {
      String sql = "INSERT INTO carta(id,nombre_carta,tipo,simbolo_expansion,rareza,"
            + "coste_mana,coste_mana_convertido,fuerza,resistencia,loyalty,"
            + "descripcion,codigo_artista,color,generated_mana,nombre_formato)" + " VALUES ('" + carta.getId() + "', '"
            + carta.getNombreCarta() + "'," + " '" + carta.getTipo() + "', '" + carta.getSimboloExpansion() + "')"
            + " '" + carta.getRareza() + "', '" + carta.getCosteMana() + "'," + " '" + carta.getCosteManaConvertido()
            + "', '" + carta.getFuerza() + "')" + " '" + carta.getResistencia() + "', '" + carta.getLoyalty() + "',"
            + " '" + carta.getDescripcion() + "', '" + carta.getCodigoArtista() + "')" + " '" + carta.getColor()
            + "', '" + carta.getGeneratedMana() + "'," + " '" + carta.getNombreFormato() + "')";
      actualizar(sql);
   }

   /**
    * Metodo que elimina una carta por el identificador
    * 
    * @param carta a eliminar
    * @throws PersistenciaException
    */
   public void eliminar(Carta carta) throws PersistenciaException {
      String sql = "DELETE from carta where id = '" + carta.getId() + "'";
      actualizar(sql);
   }

   /**
    * Metodo que se encarga de modificar una carta
    * 
    * @param carta
    * @throws PersistenciaException
    */
   public void modificar(Carta carta) throws PersistenciaException {
      String sql = " UPDATE FRUTA SET id = '" + carta.getId() + "', '" + " nombreCarta = '" + carta.getNombreCarta()
            + "', '" + " tipo = '" + carta.getTipo() + "', '" + " simboloExpansion = '" + carta.getSimboloExpansion()
            + "', '" + " rareza = '" + carta.getRareza() + "', '" + " costeMana = '" + carta.getCosteMana() + "', '"
            + " costeManaConvertido = '" + carta.getCosteManaConvertido() + "', '" + " fuerza = '" + carta.getFuerza()
            + "', '" + " resistencia = '" + carta.getResistencia() + "', '" + " loyalty = '" + carta.getLoyalty()
            + "', '" + " descripcion = '" + carta.getDescripcion() + "', '" + " codigoArtista = '"
            + carta.getCodigoArtista() + "', '" + " color = '" + carta.getColor() + "', '" + " generatedMana = '"
            + carta.getGeneratedMana() + "', '" + " nombreFormato = '" + carta.getNombreFormato() + "', '";
      actualizar(sql);
   }

   /**
    * Metodo encargado de actualizar la BBDD
    * 
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
      } finally {
         closeConecction(connection, statement, null);
      }
   }

   /***
    * Metodo encargado de realizar la consulta dsobre la BBDD y la tabla carta
    * 
    * @param sql de la consulta
    * @return lista de resultados
    * @throws PersistenciaException error controlado
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
            int id = resultSet.getInt("id");
            String nombreCarta = resultSet.getString("nombreCarta");
            String tipo = resultSet.getString("tipo");
            String simboloExpansion = resultSet.getString("simboloExpansion");
            String campoRareza = resultSet.getString("rareza");
            char rareza = campoRareza.charAt(0);
            String costeMana = resultSet.getString("costeMana");
            int costeManaConvertido = resultSet.getInt("costeManaConvertido");
            String fuerza = resultSet.getString("fuerza");
            String resistencia = resultSet.getString("resistencia");
            int loyalty = resultSet.getInt("loyalty");
            String descripcion = resultSet.getString("descripcion");
            int codigoArtista = resultSet.getInt("codigoArtista");
            String color = resultSet.getString("color");
            String generatedMana = resultSet.getString("generatedMana");
            String nombreFormato = resultSet.getString("nombreFormato");
            carta = new Carta(id, nombreCarta, tipo, simboloExpansion, rareza, costeMana, costeManaConvertido, fuerza,
                  resistencia, loyalty, descripcion, codigoArtista, color, generatedMana, nombreFormato);
            listaCartas.add(carta);
         }
      } catch (Exception exception) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta", exception);
      } finally {
         closeConecction(connection, statement, resultSet);
      }
      return listaCartas;

   }

   /**
    * Metodo que obtiene todos los datos de la lista sql de carta
    * 
    * @return
    * @throws PersistenciaException
    */
   public ArrayList<Carta> obtenerListado() throws PersistenciaException {
      String sql = "SELECT * FROM carta";
      return obtenerListado(sql);
   }

   /***
    * metodo que busca una carta dentro de la tabla carta por id
    * 
    * @param id de la carta a buscar
    * @return carta buscada
    * @throws PersistenciaException error controlado
    */
   public Carta obtenerCarta(int id) throws PersistenciaException {
      Carta carta = null;
      ArrayList<Carta> listaCartas = null;
      String sql = "SELECT * FROM carta where id=";
      sql = sql + "'" + id + "'";
      listaCartas = obtenerListado(sql);
      if (!listaCartas.isEmpty()) {
         carta = listaCartas.get(0);
      }
      return carta;
   }

   /**
    * Metodo encartgado de cerrar la conexion a la base de datos
    * 
    * @param connection
    * @param statement
    * @param resultSet
    * @throws PersistenciaException
    */
   private void closeConecction(Connection connection, Statement statement, ResultSet resultSet)
         throws PersistenciaException {
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
