package main;

import control.ControlPedidos;

/**
 * Clase principal del sistema SGP Vega's Pizza
 * @author Samuel Vega
 */
public class SGP {

    public static void main(String[] args) { 
        ControlPedidos c = ControlPedidos.getInstance();
        c.mostrarVentanaPrincipal();
    }
}
