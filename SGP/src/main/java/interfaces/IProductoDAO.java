package interfaces;

import dominio.Producto;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author Samuel Vega
 */
public interface IProductoDAO {
    
    public Producto obten(Long id) throws DAOException;
    
    public void agregarProducto(Producto producto) throws DAOException;
    
    public void modificarProducto(Producto producto) throws DAOException;
    
    public void eliminarProducto(Long id) throws DAOException;
    
    public List<Producto> obtenerProductos() throws DAOException;
}
