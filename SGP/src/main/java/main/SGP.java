package main;

import control.Control;
import dao.ClienteDAO;
import dominio.Cliente;
import dominio.Direccion;
import interfaces.IClienteDAO;

/**
 *
 * @author Samuel Vega
 */
public class SGP {

    public static void main(String[] args) {
        IClienteDAO cliente = new ClienteDAO();
        
        cliente.agregarCliente(new Cliente("Sergio Ruben", "Ramirez", "Espinoza", new Direccion("mulberry st", "Santa Cecilia", "1721", 85098, "Ciudad Obregón", "Sonora"), "6441499255"));
        
        Control c = new Control();
        c.mostrarVentanaPrincipal();
    }
}
