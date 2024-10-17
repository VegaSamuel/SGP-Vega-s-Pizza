package main;

import control.Control;

/**
 * Clase principal del sistema SGP Vega's Pizza
 * @author Samuel Vega
 */
public class SGP {

    public static void main(String[] args) { 
        Control c = Control.getInstance();
        c.mostrarVentanaPrincipal();
    }
}
