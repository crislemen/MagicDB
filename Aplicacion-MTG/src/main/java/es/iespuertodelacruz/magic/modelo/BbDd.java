package es.iespuertodelacruz.magic.modelo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class BbDd {

   private String driver;
   private String url;
   private String usuario;
   private String password;
   Fichero fichero;

   private static final String TABLE_BARAJA = "artista";
   private static final String TABLE_ARTISTA = "artista";
   private static final String TABLE_FORMATO = "formato";
   private static final String TABLE_MANA = "mana";
   private static final String TABLE_EXPANSION = "expansion";
   private static final String TABLE_BARAJA_FORMATO = "baraja_formato";
   private static final String TABLE_BARAJA_COLORES = "baraja_colores";
   private static final String TABLE_BARAJA_MANA = "baraja_mana";
   private static final String TABLE_MANA_PRODUCE = "mana_produce";
   private static final String TABLE_CARTA = "carta";
   private static final String TABLE_BARAJA_CARTA = "baraja_carta";

   public BbDd(String driver, String url, String usuario, String password) throws PersistenciaException {
      this.driver = driver;
      this.url = url;
      this.usuario = usuario;
      this.password = password;
      fichero = new Fichero();
      inicializarDdBd();
   }

   private void inicializarDdBd() throws PersistenciaException {
      DatabaseMetaData databaseMetaData;
      Connection connection = null;
      ResultSet resultSet = null;
      ArrayList<String> listaTablas = new ArrayList<>();
      try {
         connection = getConnection();
         databaseMetaData = connection.getMetaData();
         resultSet = databaseMetaData.getTables(null, null, null,
               new String[] { TABLE_BARAJA, TABLE_ARTISTA, TABLE_FORMATO, TABLE_MANA, TABLE_EXPANSION,
                     TABLE_BARAJA_FORMATO, TABLE_BARAJA_COLORES, TABLE_BARAJA_MANA, TABLE_MANA_PRODUCE, TABLE_CARTA,
                     TABLE_BARAJA_CARTA });
         while (resultSet.next()) {
            listaTablas.add(resultSet.getString("TABLE_BARAJA"));
            listaTablas.add(resultSet.getString("TABLE_ARTISTA"));
            listaTablas.add(resultSet.getString("TABLE_FORMATO"));
            listaTablas.add(resultSet.getString("TABLE_MANA"));
            listaTablas.add(resultSet.getString("TABLE_EXPANSION"));
            listaTablas.add(resultSet.getString("TABLE_BARAJA_FORMATO"));
            listaTablas.add(resultSet.getString("TABLE_BARAJA_COLORES"));
            listaTablas.add(resultSet.getString("TABLE_BARAJA_MANA"));
            listaTablas.add(resultSet.getString("TABLE_MANA_PRODUCE"));
            listaTablas.add(resultSet.getString("TABLE_CARTA"));
            listaTablas.add(resultSet.getString("TABLE_BARAJA_CARTA"));
         }
         if (!listaTablas.contains(TABLE_BARAJA) && !listaTablas.contains(TABLE_ARTISTA)
               && !listaTablas.contains(TABLE_FORMATO) && !listaTablas.contains(TABLE_MANA)
               && !listaTablas.contains(TABLE_EXPANSION) && !listaTablas.contains(TABLE_BARAJA_FORMATO)
               && !listaTablas.contains(TABLE_BARAJA_COLORES) && !listaTablas.contains(TABLE_BARAJA_MANA)
               && !listaTablas.contains(TABLE_MANA_PRODUCE) && !listaTablas.contains(TABLE_CARTA)
               && !listaTablas.contains(TABLE_BARAJA_CARTA)) {
            // Crear tabla cuenta
            String sqlCrearTablaBaraja = "CREATE TABLE IF NOT EXISTS baraja(" + " codigo INT PRIMARY KEY,"
                  + "nombre VARCHAR(50)," + "precio FLOAT," + "numero_cartas INT," + "balance_mana INT" + ");";

            String sqlCrearTablaArtista = "CREATE TABLE IF NOT EXISTS artista("
                  + " codigo INT AUTO_INCREMENT PRIMARY KEY," + "nombre VARCHAR(50)," + "apellido VARCHAR(50),"
                  + "numero_artes INT" + ");";

            String sqlCrearTablaFormato = "CREATE TABLE IF NOT EXISTS formato(" + "nombre VARCHAR(50) PRIMARY KEY,"
                  + "descripcion VARCHAR(350)," + "baneo BOOLEAN" + ");";

            String sqlCrearTablaMana = "CREATE TABLE IF NOT EXISTS mana(" + "nombre VARCHAR(50) PRIMARY KEY,"
                  + "tipo VARCHAR(30)," + "descripcion VARCHAR(150)" + ");";

            String sqlCrearTablaExpansion = "CREATE TABLE IF NOT EXISTS expansion(" + "simbolo VARCHAR(3) PRIMARY KEY,"
                  + "nombre VARCHAR(50)," + "fecha_lanzamiento DATE" + ");";

            String sqlCrearTablaBarajaFormato = "CREATE TABLE IF NOT EXISTS baraja_formato(" + "codigo_baraja INT,"
                  + "formato VARCHAR(50)," + "PRIMARY KEY(codigo_baraja, formato),"
                  + "FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo)" + ");";

            String sqlCrearTablaBarajaColores = "CREATE TABLE IF NOT EXISTS baraja_colores(" + "codigo_baraja INT,"
                  + "colores VARCHAR(30)," + "PRIMARY KEY (codigo_baraja, colores),"
                  + "FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo)" + ");";

            String sqlCrearTablaBarajaMana = "CREATE TABLE IF NOT EXISTS baraja_mana(" + "codigo_baraja INT,"
                  + "nombre_mana VARCHAR(50)," + "PRIMARY KEY (codigo_baraja, nombre_mana),"
                  + "FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),"
                  + "FOREIGN KEY (nombre_mana) REFERENCES mana(nombre)" + ");";

            String sqlCrearTablaManaProduce = "CREATE TABLE IF NOT EXISTS mana_produce(" + "nombre_mana VARCHAR(50),"
                  + "mana_produce VARCHAR(50)," + "PRIMARY KEY (nombre_mana, mana_produce),"
                  + "FOREIGN KEY (nombre_mana) REFERENCES mana(nombre)" + ");";

            String sqlCrearTablaCarta = "CREATE TABLE IF NOT EXISTS carta(" + "id INT PRIMARY KEY,"
                  + "nombre_carta VARCHAR(80)," + "tipo TEXT," + "simbolo_expansion VARCHAR(3)," + "rareza CHAR,"
                  + "coste_mana TEXT," + "coste_mana_convertido INT," + "fuerza TEXT," + "resistencia TEXT,"
                  + "loyalty INT," + "descripcion TEXT," + "codigo_artista INT," + "color TEXT,"
                  + "generated_mana text," + "nombre_formato VARCHAR(50),"
                  + "FOREIGN KEY (codigo_artista) REFERENCES artista(codigo),"
                  + "FOREIGN KEY (nombre_formato) REFERENCES formato(nombre),"
                  + "FOREIGN KEY (simbolo_expansion) REFERENCES expansion(simbolo)" + ");";

            String sqlCrearTablaBarajaCarta = "CREATE TABLE IF NOT EXISTS baraja_carta(" + "codigo_baraja INT,"
                  + "codigo_carta INT," + "PRIMARY KEY (codigo_baraja, codigo_carta),"
                  + "FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),"
                  + "FOREIGN KEY (codigo_carta) REFERENCES carta(id)" + ");";

            actualizar(sqlCrearTablaBaraja);
            actualizar(sqlCrearTablaArtista);
            actualizar(sqlCrearTablaFormato);
            actualizar(sqlCrearTablaMana);
            actualizar(sqlCrearTablaExpansion);
            actualizar(sqlCrearTablaBarajaFormato);
            actualizar(sqlCrearTablaBarajaColores);
            actualizar(sqlCrearTablaBarajaMana);
            actualizar(sqlCrearTablaManaProduce);
            actualizar(sqlCrearTablaCarta);
            actualizar(sqlCrearTablaBarajaCarta);
            // Extraer de fichero las sentencias sql para insertar en la BBDD
            // String sqlInsertarDatos = null;
            // update(sqlInsertarDatos);
            // Insertar datos
         }

      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error en la inicializacion de la BBDD", e);
      } finally {
         closeConecction(connection, null, resultSet);
      }

   }

   /**
    * Metodo que se encarga de realizar la conexion con la base de datos
    * 
    * @return conecction
    * @throws PersistenciaException error controlado
    */
   public Connection getConnection() throws PersistenciaException {
      Connection connection = null;

      try {
         Class.forName(driver);
         if (usuario != null && password != null) {
            connection = DriverManager.getConnection(url, usuario, password);
         } else {
            connection = DriverManager.getConnection(url);
         }
      } catch (ClassNotFoundException | SQLException exception) {
         throw new PersistenciaException("No se ha podido estabalecer la conexion", exception);
      }

      return connection;
   }

   /**
    * Metodo que inserta todos los artistas que hay en el fichero
    * InsertsArtista.sql
    * 
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarArtistas() throws PersistenciaException, IOException{
      String sql;
      try {
         sql = fichero.leerResource("sql/InsertsArtista.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }

      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsBaraja.sql
    * 
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */

   public void insertarBarajas() throws PersistenciaException, IOException{
      String sql;

      try {
         sql = fichero.leerResource("sql/InsertsBaraja.sql");
      } catch (PersistenciaException e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsFormato.sql
    * 
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */

   public void insertarFormatos() throws PersistenciaException, IOException{
      String sql; 
      try {
         sql = fichero.leerResource("sql/InsertsFormato.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsBaraja_carta.sql
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarBarajaCarta() throws PersistenciaException, IOException{
      String sql;
      try {
         sql = fichero.leerResource("sql/InsertsBaraja_carta.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsBaraja_colores.sql
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarBarajaColores() throws PersistenciaException, IOException{
      String sql;
      try {
         sql = fichero.leerResource("sql/InsertsBaraja_colores.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsBaraja_formato.sql
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarBarajaFormato() throws PersistenciaException, IOException{
      String sql;

      try {
         sql = fichero.leerResource("sql/InsertsBaraja_formato.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsBaraja_mana.sql
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarBarajaMana() throws PersistenciaException, IOException{
      String sql;

      try {
         sql = fichero.leerResource("sql/InsertsBaraja_mana.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsCarta.sql
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarCarta() throws PersistenciaException, IOException{
      String sql;

      try {
         sql = fichero.leerResource("sql/InsertsCarta.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsExpansion.sql
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarExpansion() throws PersistenciaException, IOException{
      String sql;
      try {
         sql = fichero.leerResource("sql/InsertsExpansion.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsMana_produce.sql
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarManaProduce() throws PersistenciaException, IOException{
      String sql;
      try {
         sql = fichero.leerResource("sql/InsertsMana_produce.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo que inserta todos los valores que hay en el fichero InsertsMana.sq
    * @throws PersistenciaException error controlado
    * @throws IOException error no controlado
    */
   public void insertarMana() throws PersistenciaException, IOException{
      String sql;

      try {
         sql = fichero.leerResource("sql/InsertsMana.sql");
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error realizando la consulta");
      }
      actualizar(sql);
   }

   /**
    * Metodo encargado de insertar una carta en la BBDD en la tabla carta
    * 
    * @param carta a insertar en la BBDD
    * @throws PersistenciaException error controlado
    */
   public void insertar(Carta carta) throws PersistenciaException {
      String sql = "INSERT or REPLACE INTO carta(id,nombre_carta,tipo,simbolo_expansion,rareza,"
            + "coste_mana,coste_mana_convertido,fuerza,resistencia,loyalty,"
            + "descripcion,codigo_artista,color,generated_mana,nombre_formato)" + " VALUES ('" + carta.getId() + "',"
            + "'" + carta.getNombreCarta() + "', " + "'" + carta.getTipo() + "', " + "'" + carta.getSimboloExpansion()
            + "'," + "'" + carta.getRareza() + "', " + "'" + carta.getCosteMana() + "', " + "'"
            + carta.getCosteManaConvertido() + "', " + "'" + carta.getFuerza() + "', " + "'" + carta.getResistencia()
            + "', " + "'" + carta.getLoyalty() + "', " + "'" + carta.getDescripcion() + "', " + "'"
            + carta.getCodigoArtista() + "', " + "'" + carta.getColor() + "', " + "'" + carta.getGeneratedMana() + "', "
            + "'" + carta.getNombreFormato() + "');";
      actualizar(sql);
   }

   /**
    * Metodo que elimina una carta por el identificador
    * 
    * @param carta a eliminar 
    * @throws PersistenciaException error controlado
    */
   public void eliminar(Carta carta) throws PersistenciaException {
      String sql = "DELETE from carta where id = '" + carta.getId() + "'";
      actualizar(sql);
   }

   /**
    * Metodo que se encarga de modificar una carta
    * 
    * @param carta a tratar
    * @throws PersistenciaException error controlado
    */
   public void modificar(Carta carta) throws PersistenciaException {
      String sql = " UPDATE carta SET nombre_carta = '" + carta.getNombreCarta() + "', " + " tipo = '" + carta.getTipo()
            + "', " + " simbolo_expansion = '" + carta.getSimboloExpansion() + "', " + " rareza = '" + carta.getRareza()
            + "', " + " coste_mana = '" + carta.getCosteMana() + "', " + " coste_mana_convertido = '"
            + carta.getCosteManaConvertido() + "', " + " fuerza = '" + carta.getFuerza() + "', " + " resistencia = '"
            + carta.getResistencia() + "', " + " loyalty = '" + carta.getLoyalty() + "', " + " descripcion = '"
            + carta.getDescripcion() + "', " + " codigo_artista = '" + carta.getCodigoArtista() + "', " + " color = '"
            + carta.getColor() + "', " + " generated_mana = '" + carta.getGeneratedMana() + "', "
            + " nombre_formato = '" + carta.getNombreFormato() + "';";
      actualizar(sql);
   }

   /**
    * Metodo encargado de actualizar la BBDD
    * 
    * @param sql a ejecutar
    * @throws PersistenciaException error controlado
    */
   public void actualizar(String sql) throws PersistenciaException {
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
   public ArrayList<Carta> buscar(String sql) throws PersistenciaException {
      ArrayList<Carta> listaCartas = new ArrayList<>();
      Statement statement = null;
      ResultSet resultSet = null;
      Connection connection = null;

      try {

         connection = getConnection();
         statement = connection.createStatement();
         resultSet = statement.executeQuery(sql);

         while (resultSet.next()) {
            Carta carta = new Carta();

            String campoRareza = resultSet.getString("rareza");
            char rareza = campoRareza.charAt(0);

            carta.setId(resultSet.getInt("id"));
            carta.setNombreCarta(resultSet.getString("nombre_carta"));
            carta.setTipo(resultSet.getString("tipo"));
            carta.setSimboloExpansion(resultSet.getString("simbolo_expansion"));
            carta.setRareza(rareza);
            carta.setCosteMana(resultSet.getString("coste_mana"));
            carta.setCosteManaConvertido(resultSet.getInt("coste_mana_convertido"));
            carta.setFuerza(resultSet.getString("fuerza"));
            carta.setResistencia(resultSet.getString("resistencia"));
            carta.setLoyalty(resultSet.getInt("loyalty"));
            carta.setDescripcion(resultSet.getString("descripcion"));
            carta.setCodigoArtista(resultSet.getInt("codigo_artista"));
            carta.setColor(resultSet.getString("color"));
            carta.setGeneratedMana(resultSet.getString("generated_mana"));
            carta.setNombreFormato(resultSet.getString("nombre_formato"));

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
    * Metodo encargado de obtener el listado
    * 
    * @param sql setencia sql
    * @return carta
    * @throws PersistenciaException error controlado
    */
   public ArrayList<Carta> obtenerListado(String sql) throws PersistenciaException {
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
            String nombreCarta = resultSet.getString("nombre_carta");
            String tipo = resultSet.getString("tipo");
            String simboloExpansion = resultSet.getString("simbolo_expansion");
            String campoRareza = resultSet.getString("rareza");
            char rareza = campoRareza.charAt(0);
            String costeMana = resultSet.getString("coste_mana");
            int costeManaConvertido = resultSet.getInt("coste_mana_convertido");
            String fuerza = resultSet.getString("fuerza");
            String resistencia = resultSet.getString("resistencia");
            int loyalty = resultSet.getInt("loyalty");
            String descripcion = resultSet.getString("descripcion");
            int codigoArtista = resultSet.getInt("codigo_artista");
            String color = resultSet.getString("color");
            String generatedMana = resultSet.getString("generated_mana");
            String nombreFormato = resultSet.getString("nombre_formato");
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
    * @return obtenerLista
    * @throws PersistenciaException error controlado
    */
   public ArrayList<Carta> obtenerListado() throws PersistenciaException {
      String sql = "SELECT * FROM carta";
      return obtenerListado(sql);
   }

   /***
    * metodo que busca una carta dentro de la tabla carta por id
    * 
    * @param id de la carta a buscar
    * @return carta
    * @throws PersistenciaException error controlado
    */
   public Object obtenerCartaId(int id) throws PersistenciaException {
      Object elemento = null;
      String sql = "SELECT * FROM carta WHERE id = '" + id + "';";
      ArrayList<Carta> listaCartas = buscar(sql);
      if (!listaCartas.isEmpty()) {
         elemento = listaCartas.get(0);
      }
      return elemento;
   }

   /**
    * Metodo que busca una carta por nombre
    * 
    * @param nombre de la carta
    * @return carta
    * @throws PersistenciaException
    */
   public Object obtenerCartaNombre(String nombreCarta) throws PersistenciaException {
      Object elemento = null;
      String sql = "SELECT * FROM carta WHERE nombre_carta = '" + nombreCarta + "';";
      ArrayList<Carta> listaCartas = buscar(sql);
      if (!listaCartas.isEmpty()) {
         elemento = listaCartas.get(0);
      }
      return elemento;
   }

   /**
    * Metodo que busca una carta por costeMana
    * 
    * @param costeMana de la carta
    * @return carta
    * @throws PersistenciaException
    */
   public Carta obtenerCartaMana(String costeMana) throws PersistenciaException {
      Carta carta = null;
      ArrayList<Carta> listaCartas = null;
      String sql = "SELECT * FROM carta where coste_mana=";
      sql = sql + "'" + costeMana + "'";
      listaCartas = obtenerListado(sql);
      if (!listaCartas.isEmpty()) {
         carta = listaCartas.get(0);
      }
      return carta;
   }

   /**
    * Metodo encargado de cerrar la conexion a la base de datos
    * 
    * @param connection
    * @param statement
    * @param resultSet
    * @throws PersistenciaException
    */
   public void closeConecction(Connection connection, Statement statement, ResultSet resultSet)
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
