package interfaces;

import dominio.Pedido;
import dominio.Venta;
import excepciones.DAOException;
import java.util.Calendar;
import java.util.List;

public interface IVentaDAO {
    
    public Venta obten(Long id) throws DAOException;
    
    public void agregarVenta(Venta venta) throws DAOException;
    
    public void modificarVenta(Venta venta) throws DAOException;
    
    public void eliminarVenta(Long id) throws DAOException;
    
    public List<Venta> obtenerVentas() throws DAOException;
    
    public List<Venta> obtenVentasPedido(Pedido pedido) throws DAOException;
    
    public List<Venta> obtenVentasEntreFechas(Calendar fechaInicio, Calendar fechaFin) throws DAOException;
}
