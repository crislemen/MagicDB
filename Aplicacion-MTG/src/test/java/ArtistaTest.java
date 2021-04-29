/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertodelacruz.ridel.api.Artista;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author risaa
 */
public class ArtistaTest {
    
    Artista artista;
    Artista artista2;
    
    private int codigoDefault = 1;
    private String nombreDefault = "Juan";
    private String apellido1Default = "Martin";
    private String apellido2Default = "Perez";
    private int numeroArtesDefault = 20;
    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";  
    
    @BeforeEach
    public void setUp() {
        if(artista == null){
            artista = new Artista();
        }
        artista = generarArtista(20, "Pedro", "Gonzales", "Martin", 15);
        artista2 = generarArtista(0, null, null, null, 0);
    }
    
    @Test
    public void comprobarArtista(){
        assertNotNull(artista2, "El objeto no se ha generado correctamente");
        assertEquals(artista.getCodigo(), 20, LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(artista.getNombre().contains("Pedro"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(artista.getApellido1().contains("Gonzales"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(artista.getApellido2().contains("Martin"),LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
    }
    
    /**
     * Funcion encargada de generar un artista
     * @param codigo 
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param numeroArtes
     * @return artista
     */
    private Artista generarArtista(int codigo, String nombre, String apellido1, 
            String apellido2, int numeroArtes){
    
        Artista artista = null;
        
        if(codigo !=0 && nombre != null && apellido1 != null && apellido2 != null
                && numeroArtes !=0){
            
            artista = new Artista(codigo, nombre, apellido1, apellido2, numeroArtes);
            
            } else {
        
            artista = new Artista();
            
            artista.setCodigo(codigoDefault);
            artista.setNombre(nombreDefault);
            artista.setApellido1(apellido1Default);
            artista.setApellido2(apellido2Default);
            artista.setNumeroArtes(numeroArtesDefault);
        
        }
        
        return artista;
    }
    

}
