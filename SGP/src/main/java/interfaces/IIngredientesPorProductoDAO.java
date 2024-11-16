package interfaces;

import dominio.IngredientesPorProducto;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author Samuel Vega
 */
public interface IIngredientesPorProductoDAO {
    
    public IngredientesPorProducto obten(Long id) throws DAOException;
    
    public void agregarIngredientesPorProducto(IngredientesPorProducto ingredientesPorProducto) throws DAOException;
    
    public void modificarIngredientesPorProducto(IngredientesPorProducto ingredientesPorProducto) throws DAOException;
    
    public void eliminarIngredientesPorProducto(Long id) throws DAOException;
    
    public List<IngredientesPorProducto> obtenerIngredientesPorProducto();
    
}
