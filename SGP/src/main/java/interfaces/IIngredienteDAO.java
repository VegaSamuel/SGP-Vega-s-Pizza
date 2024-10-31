package interfaces;

import dominio.Ingrediente;
import excepciones.DAOException;
import java.util.List;

/**
 *
 * @author Samuel Vega
 */
public interface IIngredienteDAO {
    
    public Ingrediente obten(Long id) throws DAOException;
    
    public void agregarIngrediente(Ingrediente ingrediente) throws DAOException;
    
    public void modificarIngrediente(Ingrediente ingrediente) throws DAOException;
    
    public void eliminarIngrediente(Ingrediente ingrediente) throws DAOException;
    
    public List<Ingrediente> obtenerIngredientes() throws DAOException;
}
