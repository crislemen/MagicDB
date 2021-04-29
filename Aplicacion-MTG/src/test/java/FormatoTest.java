/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertodelacruz.ridel.api.Formato;
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
public class FormatoTest {

    Formato formato;
    Formato formato2;
    
    private String nombreDefault = "Estandar";
    private String descripcionDefault = "descripcion";
    private String bansDefault = "Cauldron familiar";
    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";    
    
    @BeforeEach
    public void setUp() {
        
        if(formato == null){
            formato = new Formato();
        }
        formato = generarFormato("Modern", "modern descripcion", "mox opal");
        formato2 = generarFormato(null, null, null);
        
    }
    
    @Test
    public void comprobarFromato(){
        assertNotNull(formato2, "El objeto no se ha generado correctamente");
        assertTrue(formato.getNombre().contains("Modern"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(formato.getDescripcion().contains("modern descripcion"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(formato.getBans().contains("mox opal"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
    }

    
    /**
     * Funcion encargada de generar un formato
     * @param nombre del formato
     * @param descripcion del formato
     * @param bans del formato
     * @return formato
     */
    private Formato generarFormato(String nombre, String descripcion, String bans){
    
        Formato formato = null;
        
        if(nombre != null && descripcion != null && bans != null){
            
            formato = new Formato(nombre, descripcion, bans);
            
        } else {
            
            formato = new Formato();
            
            formato.setNombre(nombreDefault);
            formato.setDescripcion(descripcionDefault);
            formato.setBans(bansDefault);
        }
        
        return formato;
    
    }
}
