package interfaces;

import dominio.Cliente;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author Samuel Vega
 */
public interface IClienteDAO {
    
    public Cliente obten(Long id) throws DAOException;
    
    public Cliente obten(String telefono) throws DAOException;
    
    public void agregarCliente(Cliente cliente) throws DAOException;
    
    public void modificarCliente(Cliente cliente) throws DAOException;
    
    public void eliminarCliente(Long id) throws DAOException;
    
    public List<Cliente> obtenerClientes() throws DAOException;
}
