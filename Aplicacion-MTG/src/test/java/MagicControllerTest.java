import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.magic.api.Carta;
import es.iespuertodelacruz.magic.controlador.MagicController;
import es.iespuertodelacruz.magic.exception.CartaException;
import es.iespuertodelacruz.magic.exception.PersistenciaException;
import es.iespuertodelacruz.magic.modelo.MagicModelo;

public class MagicControllerTest extends UtilsTest {

    MagicModelo magicModelo;
    MagicController magicController;
    Carta cartaVacia;
    Carta carta;
    Carta carta4;
    Carta carta3 = null;
    static final String LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD = "Los valores del objeto no son los esperados";

    @BeforeEach
    public void setUp() throws PersistenciaException, CartaException {
        if (magicController == null) {
            magicController = new MagicController();
        }

        cartaVacia = new Carta(0, "", "", "", CHAR_NULL, "{3}{G}", -1, "", "", -1, "", 0, "W", "", "");
        carta = generarCarta(11111, "Bibliopex assistant", "artifact", "ORI", 'C', "{3}{G}", 4, "3", "3", 3,
                "descripcion", 7, "W", "{R}", "Pauper");
        carta4 = generarCarta(11112, "Bibliopex assistant", "artifact", "ORI", 'C', "{3}{G}", 4, "3", "3", 3,
                "descripcion", 7, "W", "{R}", "Pauper");
    }

    @Test
    public void validarTest() {

        try {
            magicController.validar(cartaVacia);
        } catch (CartaException e) {
            assertTrue(e.getMessage().contains("vacio"));
        }
    }

    @Test
    public void insertarTest() {
        try {
            magicController.insertar(carta);
        } catch (PersistenciaException | CartaException e) {

            assertTrue(e.getMessage().contains("consulta"));
        }
    }

    @Test
    public void verificarTest() {
        try {
            magicController.validar(carta3);
        } catch (CartaException e) {
            assertTrue(e.getMessage().contains("nulo"));
        }
    }

    @Test
    public void validarVacioTest() throws CartaException, PersistenciaException {

        assertEquals(0, cartaVacia.getId(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getNombreCarta().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getTipo().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getSimboloExpansion().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(CHAR_NULL, cartaVacia.getRareza(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(-1, cartaVacia.getCosteManaConvertido(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getFuerza().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getResistencia().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(-1, cartaVacia.getLoyalty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getDescripcion().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertEquals(0, cartaVacia.getCodigoArtista(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getGeneratedMana().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);
        assertTrue(cartaVacia.getNombreFormato().isEmpty(), LOS_VALORES_DEL_OBJETO_NO_SON_LOS_ESPERAD);

    }

    @Test
    public void verificarManaTest() {

        String coste_Mana = "{2}{W";
        try {
            magicController.validarMana(coste_Mana);

        } catch (CartaException e) {

            assertTrue(e.getMessage().contains("no tiene"));
        }

    }

    @Test
    public void verificarColorTest() {
        String color = "{M}";

        try {
            magicController.validarColor(color);
        } catch (CartaException e) {
            assertTrue(e.getMessage().contains("no tiene"));
        }

    }

    @Test
    public void buscarCartaPorId() {
        int id = 2;
        try {
            magicController.buscarPorID(id);
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
        }
    }

    @Test
    public void buscarPorNombreTest() {
        String nombreCarta = "Bibliopex assistant";
        try {
            magicController.buscarPorNombre(nombreCarta);
        } catch (PersistenciaException e) {

            assertFalse(e.getMessage().contains("consulta"));
        }
    }

    @Test
    public void buscarPorCosteManaTest() {
        String costeMana = "{2}{W}";
        try {
            magicController.buscarPorCosteMana(costeMana);
        } catch (PersistenciaException e) {

            assertFalse(e.getMessage().contains("consulta"));
        }
    }
    @Test
    public void modificarTest() {

        /*
        try {
            Carta cartaEncontrado = magicModelo.buscarPorID(carta.getId());
            assertNotNull(cartaEncontrado, "No se debe de obtener un elemento nulo");
            cartaEncontrado.setNombreCarta("Pepe 2");
            cartaEncontrado.modificar(cartaEncontrado);
            Carta cartaActualizada = magicModelo.buscarPorID(cartaEncontrado.getId());
            assertEquals(cartaActualizada, cartaEncontrado, "No se ha encontrado lo esperado");
        } catch (PersistenciaException e) {
           fail("Se ha producido un error en la consulta del la cliente,e:"+e.getMessage());
        }*/
        if (carta4.getId() == 11112) {

            try {
                magicController.modificar(carta4);
    
            } catch (PersistenciaException e) {
                assertFalse(e.getMessage().contains("consulta"));
            }
        }

    }

    @Test
    public void obtenerListadoTest(){
        try {
            magicController.obtenerListado();
        } catch (PersistenciaException e) {
            assertFalse(e.getMessage().contains("consulta"));
        }
    }
    @Test
    public void eliminarTest() {
        try {
            magicController.eliminar(carta);
        } catch (PersistenciaException e) {

            assertFalse(e.getMessage().contains("consulta"));
        }
    }



}
