import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.MagicModelo;

public class MagicModeloTes {
    
    static MagicModelo magicModelo;

    @BeforeEach
    public static void setUp(){
        if(magicModelo == null){
            try {
                magicModelo = new MagicModelo();
            } catch (Exception e) {
                fail("Se ha producido un error en el indicio de la BBDD");
            }
        }
    }

    @Test
    public void h(){
        assertTrue(true);
    }
}
