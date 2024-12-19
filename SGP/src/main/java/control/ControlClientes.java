package control;

import dao.ClienteDAO;
import dominio.Cliente;
import interfaces.IClienteDAO;
import java.util.List;
import util.DBConector;

/**
 * Esta clase lleva el control de los clientes.
 * @author Samuel Vega
 */
public class ControlClientes {
    private static ControlClientes instancia;
    
    public ControlClientes() {}
    
    public static ControlClientes getInstance() {
        if(instancia == null) {
            instancia = new ControlClientes();
        }
        return instancia;
    }
    
    public Cliente getCliente(Long id) {
        IClienteDAO clientes = new ClienteDAO(new DBConector().getEM());
        return clientes.obten(id);
    }
    
    public void agregarCliente(Cliente cliente) {
        IClienteDAO clientes = new ClienteDAO(new DBConector().getEM());
        clientes.agregarCliente(cliente);
    }
    
    public void modificarCliente(Cliente cliente) {
        IClienteDAO clientes = new ClienteDAO(new DBConector().getEM());
        clientes.modificarCliente(cliente);
    }
    
    public void elimnarCliente(Long id) {
        IClienteDAO clientes = new ClienteDAO(new DBConector().getEM());
        clientes.eliminarCliente(id);
    }
    
    public List<Cliente> obtenerClientes() {
        IClienteDAO clientes = new ClienteDAO(new DBConector().getEM());
        return clientes.obtenerClientes();
    }
}
