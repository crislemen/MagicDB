/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertodelacruz.ridel.api.Baraja;
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
public class BarajaTest {
    
    Baraja baraja;
    Baraja baraja2;
    
    private String nombreDefault = "golgari";
    private String formatoDefault = "pauper, estandar";
    private float precioDefault = 300;
    private int numeroCartasDefault = 100;
    private int balanceManaDefault = 31;
    private String coloresDefault = "negro, verde";
    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";  
    
    @BeforeEach
    public void setUp() {
        
        if(baraja == null){
            baraja = new Baraja();
        }
        baraja = generarBaraja("muros", "pauper", 15, 60, 20, "verde, azul");
        baraja2 = generarBaraja(null, null, 0, 0, 0, null);       
    }
    
    @Test
    public void comprobarBaraja(){
    
        assertNotNull(baraja2, "El objeto no se ha generado correctamente");
        assertTrue(baraja.getNombre().contains("muros"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(baraja.getFormato().contains("pauper"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(baraja.getPrecio(), 15, LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(baraja.getNumeroCartas(), 60, LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(baraja.getBalanceMana(), 20, LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(baraja.getColores().contains("verde, azul"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
    }
    
    /**
     * Funcion ecnargada de generar una baraja
     * @param nombre de la baraja
     * @param formato de la baraja
     * @param precio de la baraja
     * @param numeroCartas de la baraja
     * @param balanceMana de la baraja
     * @param colores de la baraja
     * @return baraja
     */
    private Baraja generarBaraja(String nombre, String formato, float precio,
            int numeroCartas, int balanceMana, String colores){
    
        Baraja baraja = null;
    
        if(nombre != null && formato != null && precio !=0 && numeroCartas != 0
                && balanceMana !=0 && colores != null){
            
            baraja = new Baraja(nombre, formato, precio, numeroCartas, balanceMana, colores);
            
        } else{
        
            baraja = new Baraja();
            
            baraja.setNombre(nombreDefault);
            baraja.setFormato(formatoDefault);
            baraja.setPrecio(precioDefault);
            baraja.setNumeroCartas(numeroCartasDefault);
            baraja.setColores(coloresDefault);
            baraja.setBalanceMana(balanceManaDefault);
        }
        
        
        return baraja;
    
    }
    
}
    

