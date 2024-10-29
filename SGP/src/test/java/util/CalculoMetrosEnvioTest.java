package util;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Samuel Vega
 */
public class CalculoMetrosEnvioTest {

    /**
     * Test of getDistanciaMetros method, of class CalculoMetrosEnvio.
     */
    @Test
    public void testGetDistanciaMetros() {
        System.out.println("Prueba de CalculoMetrosEnvio.getDistanciaMetros()");
        CalculoMetrosEnvio cme = new CalculoMetrosEnvio();
        String direccion = "San Francisco 614, Campanario, Ciudad Obregón";
        
        try {
            int distancia = cme.getDistanciaMetros(direccion);
            System.out.println("Distancia en metros: " + distancia);
            assertTrue(distancia > 0, "La distancia debe ser mayor a 0");
        } catch(IOException | InterruptedException e) {
            fail("Error durante la prueba: " + e.getMessage());
        }
        
    }

    /**
     * Test of obtenerCoordenadas method, of class CalculoMetrosEnvio.
     */
    @Test
    public void testObtenerCoordenadas() {
        System.out.println("Prueba de CalculoMetrosEnvio.obtenerCoordenadas()");
        CalculoMetrosEnvio cme = new CalculoMetrosEnvio();
        String direccion = "C. Manuel Acuña 1721, 85098 Cdad. Obregón, Son.";
        
        try {
            double[] coor = cme.obtenerCoordenadas(direccion);
            
            assertNotNull(coor, "Las cordenadas no deben ser nulas");
            assertEquals(2, coor.length, "Debe haber dos coordenadas: longitud y latitud");
            System.out.println("Coordenadas: " + coor[0] + ", " + coor[1]);
        }catch(IOException | InterruptedException e) {
            fail("Error al obtener las coordenadas: " + e.getMessage());
        }
    }

    @Test
    public void testTiempoDeRespuesta() throws IOException, InterruptedException {
        System.out.println("Prueba de tiempo de respuesa de CalculoMetrosEnvio.getDistanciaMetros()");
        CalculoMetrosEnvio cme = new CalculoMetrosEnvio();
        String direccion = "San Francisco 614, Campanario, Ciudad Obregón";
        
        long inicio = System.currentTimeMillis();
        int distancia = cme.getDistanciaMetros(direccion);
        long duracion = System.currentTimeMillis() - inicio;
        
        System.out.println("Tiempo de respuesta: " + duracion + " ms");
        assertTrue(duracion < 2000, "La respuesta debe ser menor a 2 segundos");
    }

}
