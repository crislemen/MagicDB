package es.iespuertodelacruz.magic.modelo;

import java.io.*;
import java.util.Scanner;
import es.iespuertodelacruz.magic.exception.PersistenciaException;

public class Fichero {
   private static final String RETORNO_CARRO = "\n";
   private static final String ARTISTA = "/InsertsArtista.sql";
   /**
    * Funcion encargada de leer un fichero
    * 
    * @param nombre nombre del fichero a leer
    * @throws PersistenciaException Error controlado en la lectura del fichero
    */
   public String leer(String nombre) throws PersistenciaException {
      StringBuilder informacion = null;
      File fichero = null;
      Scanner scanner = null;

      try {
         fichero = new File(nombre);
         if (!validarFichero(fichero)) {
            throw new PersistenciaException("El fichero a leer no existe");
         }
         informacion = new StringBuilder();
         scanner = new Scanner(fichero);

         while (scanner.hasNextLine()) {
            String linea = scanner.nextLine(); // Guardamos la linea en un String
            informacion.append(linea + RETORNO_CARRO);
         }
      } catch (PersistenciaException e) {
         throw e;
      } catch (Exception e) {
         throw new PersistenciaException("Se ha producido un error en la lectura del fichero", e);
      } finally {
         if (scanner != null) {
            scanner.close();
         }
      }
      return informacion.toString();
   }

   /**
    * Metodo encargado de leer desde resources
    * @param nombre del fichero
    * @return content
    * @throws IOException error no controlado
    * @throws PersistenciaException error controlado
    */
   public String leerResource(String nombre){
          
      return null;

   }

   /**
    * Metodo encargado de crear un fichero
    * 
    * @param nombre del fichero a crear
    * @throws PersistenciaException
    */
   public void crear(String nombre, String cadenaTexto) throws PersistenciaException {
      FileWriter fichero = null;
      try {
         fichero = new FileWriter(nombre);
         fichero.write(cadenaTexto + "\n");
      } catch (Exception ex) {
         throw new PersistenciaException("Se ha producido un error en la escritura del fichero", ex);
      } finally {
         if (fichero != null) {
            try {
               fichero.close();
            } catch (IOException e) {
               throw new PersistenciaException("No ha sido podible cerrar el fichero", e);
            }
         }
      }

   }

   /**
    * Funcion que verifica si el fichero existo
    * @param fichero
    * @return true/false
    */
   public boolean validarFichero(File fichero) {
      return fichero.exists();
   }

   /**
    * Metodo encargado de elimianr un fichero/directorio
    * 
    * @param nombre del fichero/directorio a elimina
    * @throws PersistenciaException error controlado
    */
   public void eliminar(String nombre) throws PersistenciaException {
      File fichero = new File(nombre);
      if (validarFichero(fichero)) {
         fichero.delete();
      } else {
         throw new PersistenciaException("No se puede eliminar un fichero que no existe");
      }

   }
}
