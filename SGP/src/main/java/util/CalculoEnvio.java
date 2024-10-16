package util;

/**
 *
 * @author Samuel Vega
 */
public class CalculoEnvio {
    
    public float calcularCostoEnvio(int distanciaMetros) {
        float costo = 0.0f;
        
        if(distanciaMetros < 0) {
            System.out.println("No es posible sacar una");
        }else if(distanciaMetros >= 1 && distanciaMetros <= 4000) {
            costo = 30.0f;
        }else if(distanciaMetros >= 4001 && distanciaMetros <= 5000) {
            costo = 35.0f;
        }else if(distanciaMetros >= 5001 && distanciaMetros <= 6000) {
            costo = 40.0f;
        }else if(distanciaMetros >= 6001 && distanciaMetros <= 7000) {
            costo = 45.0f;
        }else if(distanciaMetros >= 7001 && distanciaMetros <= 8000) {
            costo = 50.0f;
        }else if(distanciaMetros >= 8001 && distanciaMetros <= 9000) {
            costo = 55.0f;
        }else if(distanciaMetros >= 9001) {
            costo = 60.0f;
        }
        
        return costo;
    }
    
}
