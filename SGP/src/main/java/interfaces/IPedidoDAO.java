package interfaces;

import dominio.Pedido;
import excepciones.DAOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Samuel Vega
 */
public interface IPedidoDAO {
    
    public Pedido obten(Long id) throws DAOException;
    
    public void agregarPedido(Pedido pedido) throws DAOException;
    
    public void modificarPedido(Pedido pedido) throws DAOException;
    
    public void eliminarPedido(Long id) throws DAOException;
    
    public List<Pedido> obtenerPedidos() throws DAOException;
    
    public List<Pedido> obtenerPedidosEntreFechas(Calendar fechaInicio, Calendar fechaFin) throws DAOException;
}
