package interfaces;

import dominio.Cliente;
import java.util.List;

/**
 *
 * @author Samuel Vega
 */
public interface IClienteDAO {
    
    public Cliente obten(Long id);
    
    public Cliente obten(String telefono);
    
    public void agregarCliente(Cliente cliente);
    
    public void modificarCliente(Cliente cliente);
    
    public void eliminarCliente(Long id);
    
    public List<Cliente> verClientes();
}
