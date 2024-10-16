package main;

import control.Control;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.CalculoMetrosEnvio;

/**
 *
 * @author Samuel Vega
 */
public class SGP {

    public static void main(String[] args) {
        CalculoMetrosEnvio distance = new CalculoMetrosEnvio();
        
        try {
            int distance1 = distance.getDistanciaMetros("Blvd. Vía de las Misiones 2136, Las Misiones, 85099 Cdad. Obregón, Son.");
            
            System.out.println(distance1);
        }catch (IOException ioe) {
            System.out.println("error");
        } catch (InterruptedException ex) {
            Logger.getLogger(SGP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Control c = Control.getInstance();
        //c.mostrarVentanaPrincipal();
    }
}
