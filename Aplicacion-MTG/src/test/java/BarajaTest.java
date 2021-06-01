/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import es.iespuertodelacruz.magic.api.Baraja;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author risaa
 */
public class BarajaTest {
    
    Baraja baraja;
    Baraja baraja2;
    
    private int codigoDefault = 1;
    private String nombreDefault = "golgari";
    private float precioDefault = 300;
    private int numeroCartasDefault = 100;
    private int balanceManaDefault = 31;

    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";  
    
    @BeforeEach
    public void setUp() {
        
        if(baraja == null){
            baraja = new Baraja();
        }
        baraja = generarBaraja(1, "golgari", 50, 60, 20);
        baraja2 = generarBaraja(0, null, 0, 0, 0);       
    }
    
    @Test
    public void comprobarBaraja(){
    
        assertNotNull(baraja2, "El objeto no se ha generado correctamente");
        assertEquals(1, baraja.getCodigo(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(baraja.getNombre().contains("golgari"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(50, baraja.getPrecio(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(60, baraja.getNumeroCartas(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(20, baraja.getBalanceMana(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
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
    private Baraja generarBaraja(int codigo, String nombre, float precio,
            int numeroCartas, int balanceMana){
    
        Baraja baraja = null;
    
        if(codigo != 0 && nombre != null && precio !=0 && numeroCartas != 0
                && balanceMana !=0){
            
            baraja = new Baraja(codigo, nombre, precio, numeroCartas, balanceMana);
            
        } else{
        
            baraja = new Baraja();
            
            baraja.setCodigo(codigoDefault);
            baraja.setNombre(nombreDefault);
            baraja.setPrecio(precioDefault);
            baraja.setNumeroCartas(numeroCartasDefault);
            baraja.setBalanceMana(balanceManaDefault);
        }
        
        
        return baraja;
    
    }
    
}
    

