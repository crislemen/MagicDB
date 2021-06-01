/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertodelacruz.magic.api.Mana;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManaTest {

    Mana mana;
    Mana mana2;
    
    private String nombreDefault = "Bosque";
    private String tipoDefault = "tierra basica";
    private String descripcionDefault = "descripcion";
        
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";    
    
    @BeforeEach
    public void setUp() {
        if(mana == null){
        
            mana = new Mana();
        }
        mana = generarMana("Pantano", "Tierra basica", "descripcion carta");
        mana2 = generarMana(null, null, null);
    }
    
    
    @Test
    public void comprobarMana(){
    
        assertNotNull(mana2, "El objeto no se ha generado correctamente");
        assertTrue(mana.getNombre().contains("Pantano"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(mana.getTipo().contains("Tierra basica"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(mana.getDescripcion().contains("descripcion carta"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
    }
    
    /**
     * Funcion encargada de generar un mana
     * @param nombre del mana
     * @param tipo del mana
     * @param descripcion del mana
     * @param manaProduce la carta
     * @return mana
     */
    private Mana generarMana(String nombre, String tipo, String descripcion){
    
        Mana mana = null;
        
        if( nombre != null && tipo != null && descripcion != null){
            
            mana = new Mana(nombre, tipo, descripcion);
        
        } else{
        
            mana = new Mana();
            
            mana.setNombre(nombreDefault);
            mana.setTipo(tipoDefault);
            mana.setDescripcion(descripcionDefault);
        }
        
        return mana;
    
    }

}
