package interfaces;

import dominio.Pedido;
import java.util.List;

/**
 *
 * @author Samuel Vega
 */
public interface IPedidoDAO {
    
    public Pedido obten(Long id);
    
    public void agregarPedido(Pedido pedido);
    
    public void modificarPedido(Pedido pedido);
    
    public void eliminarPedido(Long id);
    
    public List<Pedido> verPedidos();
}
