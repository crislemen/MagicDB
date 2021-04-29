import es.iespuertodelacruz.ridel.api.Expansion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpansionTest {
    
    Expansion expansion;
    Expansion expansion2;
    
    private String nombreDefault = "Alpha";
    private String simboloDefault = "A";
    private String fechaLanzamientoDefault = "10-10-1999";
    private String descripcionDefault = "descripcion expansion";
    
    private static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";    
    
    @BeforeEach
    public void setUp() {
        if(expansion == null){
            expansion = new Expansion();
        }
        expansion = generarExpansion("Beta", "B", "1-1-1998", "descripcion beta");
        expansion2 = generarExpansion(null, null, null, null);
    }
    
    @Test
    public void comprobarExpansion(){
        
        assertNotNull(expansion2, "El objeto no se ha generado correctamente");
        assertTrue(expansion.getNombre().contains("Beta"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(expansion.getSimbolo().contains("B"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(expansion.getFechaLanzamiento().contains("1-1-1998"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(expansion.getDescripcion().contains("descripcion beta"), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
    
    }
    
    /**
     * Funcion encargada de generar una expansion
     * @param nombre de la expansion
     * @param simbolo de la expansion
     * @param fechaLanzamiento de la expansion
     * @param descripcion de la expansion
     * @return expansion
     */
    private Expansion generarExpansion(String nombre, String simbolo, String fechaLanzamiento, String descripcion){
    
        Expansion expansion = null;
        
        if(nombre != null && simbolo != null && fechaLanzamiento != null && descripcion !=null){
            
            expansion = new Expansion(nombre, simbolo, fechaLanzamiento, descripcion);
        } else{
        
            expansion = new Expansion();
            
            expansion.setNombre(nombreDefault);
            expansion.setSimbolo(simboloDefault);
            expansion.setFechaLanzamiento(fechaLanzamientoDefault);
            expansion.setDescripcion(descripcionDefault);
        }
        
        return expansion;
    }

}
